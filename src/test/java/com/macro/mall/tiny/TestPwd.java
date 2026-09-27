package com.macro.mall.tiny;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPwd {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPwd = "123456";
        String hash = encoder.encode(rawPwd);
        System.out.println("生成的BCrypt：" + hash);

        // 直接校验测试
        boolean ok = encoder.matches(rawPwd, hash);
        System.out.println("校验结果：" + ok);
    }
}