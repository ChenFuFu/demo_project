package com.chen.springbase.dev33.satoken.context;

import com.chen.springbase.dev33.satoken.context.model.SaRequest;
import com.chen.springbase.dev33.satoken.context.model.SaResponse;
import com.chen.springbase.dev33.satoken.context.model.SaStorage;

/**
 * Sa-Token 上下文处理器 [ThreadLocal版本] 
 * @author kong
 *
 */
public class SaTokenContextForThreadLocal implements SaTokenContext {

	@Override
	public SaRequest getRequest() {
		return SaTokenContextForThreadLocalStorage.getRequest();
	}

	@Override
	public SaResponse getResponse() {
		return SaTokenContextForThreadLocalStorage.getResponse();
	}

	@Override
	public SaStorage getStorage() {
		return SaTokenContextForThreadLocalStorage.getStorage();
	}

	@Override
	public boolean matchPath(String pattern, String path) {
		return false;
	}

}
