package com.chen.springbase;

import org.junit.jupiter.api.Test;

//@SpringBootTest
public class SpringbaseApplicationTests {

    @Test
    void contextLoads() {
        Object obj = new Object();
        obj = "";
        boolean str = obj.equals("");
        System.out.println(str);
    }

}
