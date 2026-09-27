package com.macro.mall.tiny;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class TestBcrypt {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {
        String raw = "123456";
        String hash = passwordEncoder.encode(raw);
        System.out.println("加密串："+hash);
        boolean ok = passwordEncoder.matches(raw, hash);
        System.out.println("比对结果："+ok);
    }
}
