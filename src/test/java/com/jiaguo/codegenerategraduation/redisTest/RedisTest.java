package com.jiaguo.codegenerategraduation.redisTest;

import com.alibaba.fastjson2.JSON;
import com.jiaguo.codegenerategraduation.CodeGenerateGraduationApplication;
import com.jiaguo.codegenerategraduation.util.RedisCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class RedisTest {

// 测试redis
    @Autowired
    private RedisCache redisTemplate;

    @Test
    public void testRedis() {

        // redis存入对象
        class A{
            private String name;
            private int age;

            public A() {
            }

            public A(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            @Override
            public String toString() {
                return "A{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }


        A jiaGuo = new A("JiaGuo", 18);
        redisTemplate.setCacheObject("jiaGuo", JSON.toJSON(jiaGuo));
        Object jiaGuo1 = redisTemplate.getCacheObject("jiaGuo");
        System.out.println("JSON.parse(jiaGuo1.toString()) = " + JSON.parse(jiaGuo1.toString()));


    }

    @Test
    public void testRedis2() {
        Object jiaGuo1 = redisTemplate.getCacheObject("login:1");

        }



}
