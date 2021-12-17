package com.qianxia.experiment.file;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;

/**
 * @author qianxia
 * @date 2021/12/3  17:02
 */
public class FileDemo {


    public void test(MultipartFile file) throws Exception {

        //路径前缀
        String pathPrefix = getUploadPath();
        //完整路径

        File fileToBeWrite = new File(pathPrefix);
        if (!fileToBeWrite.getParentFile().exists()) {
            fileToBeWrite.getParentFile().mkdirs();
        }
        //写文件到本地
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileToBeWrite));
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }


    /**
     * 获取当前系统路径
     */
    String getUploadPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(), "user/maleon/");
        if (!upload.exists()) {
            upload.mkdirs();
        }
        return upload.getAbsolutePath();
    }
}
