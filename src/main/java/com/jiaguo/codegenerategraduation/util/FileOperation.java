package com.jiaguo.codegenerategraduation.util;

import com.jiaguo.codegenerategraduation.common.exception.FileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/7/4 21:55
 * @description：文件写入读取
 * @modified By：
 * @version: 1.0
 */
public class FileOperation {
    //log
    private static final Logger logger = LoggerFactory.getLogger(FileOperation.class);


    // 删除文件
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (FileException e) {
            logger.error("删除文件异常：" + e.getMessage());
        }
    }



//
//
//    /**
//     * @param filePath 文件路径
//     * @param fileName 文件名
//     * @param content 内容
//     * @return 是否写入成功
//     */
//    public static boolean writeFile(String filePath, String fileName, String content) {
//        try {
//            FileUtil.createFile(filePath, fileName);
//            FileUtil.writeFile(filePath + fileName, content);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    /**
//     * @param filePath 文件路径
//     * @param fileName 文件名
//     * @param content 内容
//     * @return 是否写入成功
//     */
//    public static boolean writeFile(String filePath, String fileName, String content, boolean append) {
//        try {
//            FileUtil.createFile(filePath, fileName);
//            FileUtil.writeFile(filePath + fileName, content, append);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    /**
//     * @param filePath 文件路径
//     * @param fileName 文件名
//     * @param content 内容
//     * @return 是否写入成功
//     */
//    public static boolean writeFile(String filePath, String fileName, byte[] content) {
//        try {
//            FileUtil.createFile(filePath, fileName);
//            FileUtil.writeFile(filePath + fileName, content);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    /**
//     * @param filePath 文件路径
//     * @param
//     * */
}
