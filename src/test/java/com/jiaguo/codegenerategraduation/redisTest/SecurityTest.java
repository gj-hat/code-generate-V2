package com.jiaguo.codegenerategraduation.redisTest;

import com.alibaba.fastjson2.JSON;
import com.jiaguo.codegenerategraduation.CodeGenerateGraduationApplication;
import com.jiaguo.codegenerategraduation.util.RedisCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/27 22:59
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CodeGenerateGraduationApplication.class)
public class SecurityTest {


@Test
public void TestBCryptPasswordEncoder() {
    BCryptPasswordEncoder passwordEncoder = ;
    String encode = passwordEncoder.encode("321321");
    System.out.println("encode = " + encode);

}


}
