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

    @Test
    public void likeString() {
        String par = "夫我";
        String text = "阿道夫我阿道夫";
        System.out.println(text.indexOf(par));
    }

}
