package com.chen.springbase.dev33.satoken;

import com.chen.springbase.dev33.satoken.action.SaTokenAction;
import com.chen.springbase.dev33.satoken.action.SaTokenActionDefaultImpl;
import com.chen.springbase.dev33.satoken.config.SaTokenConfig;
import com.chen.springbase.dev33.satoken.config.SaTokenConfigFactory;
import com.chen.springbase.dev33.satoken.context.SaTokenContext;
import com.chen.springbase.dev33.satoken.context.SaTokenContextDefaultImpl;
import com.chen.springbase.dev33.satoken.dao.SaTokenDao;
import com.chen.springbase.dev33.satoken.dao.SaTokenDaoDefaultImpl;
import com.chen.springbase.dev33.satoken.exception.SaTokenException;
import com.chen.springbase.dev33.satoken.listener.SaTokenListener;
import com.chen.springbase.dev33.satoken.listener.SaTokenListenerDefaultImpl;
import com.chen.springbase.dev33.satoken.stp.StpInterface;
import com.chen.springbase.dev33.satoken.stp.StpInterfaceDefaultImpl;
import com.chen.springbase.dev33.satoken.stp.StpLogic;
import com.chen.springbase.dev33.satoken.stp.StpUtil;
import com.chen.springbase.dev33.satoken.temp.SaTempDefaultImpl;
import com.chen.springbase.dev33.satoken.temp.SaTempInterface;
import com.chen.springbase.dev33.satoken.util.SaFoxUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理 Sa-Token 所有接口对象 
 * @author kong
 *
 */
public class SaManager {

	/**
	 * 配置文件 Bean 
	 */
	public static SaTokenConfig config;	
	public static void setConfig(SaTokenConfig config) {
		SaManager.config = config;
		if(config.getIsPrint()) {
			SaFoxUtil.printSaToken();
		}
		// 调用一次StpUtil中的方法，保证其可以尽早的初始化 StpLogic 
		StpUtil.getLoginType();
	}
	public static SaTokenConfig getConfig() {
		if (config == null) {
			synchronized (SaManager.class) {
				if (config == null) {
					setConfig(SaTokenConfigFactory.createConfig());
				}
			}
		}
		return config;
	}
	
	/**
	 * 持久化 Bean 
	 */
	private static SaTokenDao saTokenDao;
	public static void setSaTokenDao(SaTokenDao saTokenDao) {
		if((SaManager.saTokenDao instanceof SaTokenDaoDefaultImpl)) {
			((SaTokenDaoDefaultImpl)SaManager.saTokenDao).endRefreshThread();
		}
		SaManager.saTokenDao = saTokenDao;
	}
	public static SaTokenDao getSaTokenDao() {
		if (saTokenDao == null) {
			synchronized (SaManager.class) {
				if (saTokenDao == null) {
					setSaTokenDao(new SaTokenDaoDefaultImpl());
				}
			}
		}
		return saTokenDao;
	}
	
	/**
	 * 权限认证 Bean 
	 */
	private static StpInterface stpInterface;
	public static void setStpInterface(StpInterface stpInterface) {
		SaManager.stpInterface = stpInterface;
	}
	public static StpInterface getStpInterface() {
		if (stpInterface == null) {
			synchronized (SaManager.class) {
				if (stpInterface == null) {
					setStpInterface(new StpInterfaceDefaultImpl());
				}
			}
		}
		return stpInterface;
	}
	
	/**
	 * 框架行为 Bean 
	 */
	private static SaTokenAction saTokenAction;
	public static void setSaTokenAction(SaTokenAction saTokenAction) {
		SaManager.saTokenAction = saTokenAction;
	}
	public static SaTokenAction getSaTokenAction() {
		if (saTokenAction == null) {
			synchronized (SaManager.class) {
				if (saTokenAction == null) {
					setSaTokenAction(new SaTokenActionDefaultImpl());
				}
			}
		}
		return saTokenAction;
	}
	
	/**
	 * 容器操作 Bean  
	 */
	private static SaTokenContext saTokenContext;
	public static void setSaTokenContext(SaTokenContext saTokenContext) {
		SaManager.saTokenContext = saTokenContext;
	}
	public static SaTokenContext getSaTokenContext() {
		if (saTokenContext == null) {
			synchronized (SaManager.class) {
				if (saTokenContext == null) {
					setSaTokenContext(new SaTokenContextDefaultImpl());
				}
			}
		}
		return saTokenContext;
	}

	/**
	 * 侦听器 Bean  
	 */
	private static SaTokenListener saTokenListener;
	public static void setSaTokenListener(SaTokenListener saTokenListener) {
		SaManager.saTokenListener = saTokenListener;
	}
	public static SaTokenListener getSaTokenListener() {
		if (saTokenListener == null) {
			synchronized (SaManager.class) {
				if (saTokenListener == null) {
					setSaTokenListener(new SaTokenListenerDefaultImpl());
				}
			}
		}
		return saTokenListener;
	}

	/**
	 * 临时令牌验证模块 Bean  
	 */
	private static SaTempInterface saTemp;
	public static void setSaTemp(SaTempInterface saTemp) {
		SaManager.saTemp = saTemp;
	}
	public static SaTempInterface getSaTemp() {
		if (saTemp == null) {
			synchronized (SaManager.class) {
				if (saTemp == null) {
					setSaTemp(new SaTempDefaultImpl());
				}
			}
		}
		return saTemp;
	}
	
	/**
	 * StpLogic集合, 记录框架所有成功初始化的StpLogic 
	 */
	public static Map<String, StpLogic> stpLogicMap = new HashMap<String, StpLogic>();
	
	/**
	 * 向集合中 put 一个 StpLogic 
	 * @param stpLogic StpLogic
	 */
	public static void putStpLogic(StpLogic stpLogic) {
		stpLogicMap.put(stpLogic.getLoginType(), stpLogic);
	}

	/**
	 * 根据 LoginType 获取对应的StpLogic，如果不存在则抛出异常 
	 * @param loginType 对应的账号类型 
	 * @return 对应的StpLogic
	 */
	public static StpLogic getStpLogic(String loginType) {
		// 如果type为空则返回框架内置的 
		if(loginType == null || loginType.isEmpty()) {
			return StpUtil.stpLogic;
		}
		
		// 从SaManager中获取 
		StpLogic stpLogic = stpLogicMap.get(loginType);
		if(stpLogic == null) {
			/*
			 * 此时有两种情况会造成 StpLogic == null 
			 * 1. loginType拼写错误，请改正 （建议使用常量） 
			 * 2. 自定义StpUtil尚未初始化（静态类中的属性至少一次调用后才会初始化），解决方法两种
			 * 		(1) 从main方法里调用一次
			 * 		(2) 在自定义StpUtil类加上类似 @Component 的注解让容器启动时扫描到自动初始化 
			 */
			throw new SaTokenException("未能获取对应StpLogic，type="+ loginType);
		}
		
		// 返回 
		return stpLogic;
	}
	
	
}
