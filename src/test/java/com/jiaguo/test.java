package com.jiaguo;

import org.junit.Test;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/7/8 20:14
 * @description：
 * @modified By：
 * @version: 1.0
 */

public class test {



    @Test
    public void test() {
        int[][] yanghui=new int[10][];
        for (int i=0;i< yanghui.length;i++){
            yanghui[i]=new int[i+1] ;
            for (int j=0;j<yanghui[i].length;j++){
//                if (j==0 || j==yanghui.length-1){
                if (j==0 || j==i){
                    yanghui[i][j]=1;
                }else {
                    yanghui[i][j] = yanghui[i-1][j]+yanghui[i-1][j-1];
                }
            }
        }
        for (int i=0;i<yanghui.length;i++){
            for (int j=0;j<yanghui[i].length;j++){
                System.out.println(yanghui[i][j]+"\t");
            }
            System.out.println();
        }
    }




}
