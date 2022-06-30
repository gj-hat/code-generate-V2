package com.jiaguo.codegenerategraduation.maperrTest;

import com.jiaguo.codegenerategraduation.web.controller.vo.SysMenuVo;
import com.jiaguo.codegenerategraduation.web.mapper.SysMenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 21:36
 * @description：
 * @modified By：
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysMenu {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Test
    public void test() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);


        List<SysMenuVo> sysMenuVos = sysMenuMapper.selectByLoginUser(arrayList);
        sysMenuVos.forEach(System.out::println);
//        System.out.println(sysMenuMapper.selectList(null));
    }


}
