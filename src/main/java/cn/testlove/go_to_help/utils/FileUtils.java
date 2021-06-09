package cn.testlove.go_to_help.utils;

import cn.testlove.go_to_help.entity.PostFile;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 21:10
 * @Description: 用于文件的上传和下载
 */
@Component
@Slf4j
public class FileUtils {
    @Resource
    private Environment environment;
    private static String FILE_UPLOAD_PATH;
    private static String FILE_MAP;
    private static String IP;
    @PostConstruct
    public void setFileUploadPath(){
        FILE_UPLOAD_PATH = environment.getProperty("file.upload.path");
    }
    @PostConstruct
    public void setFileMap(){
        FILE_MAP = environment.getProperty("file.map");
    }
    @PostConstruct
    public void setIP(){
        IP = environment.getProperty("file.upload.ip");
    }

    /**
     * 用于上传文件
     * @param file
     * @param postFile
     * @return
     */
    public static boolean uploadFile(MultipartFile file, PostFile postFile)  {
        String fileUploadPath = FILE_UPLOAD_PATH + File.separator;
        File fileUploadDIR = new File(fileUploadPath);
        if(!fileUploadDIR.exists()){
            fileUploadDIR.mkdirs();
        }

            File uploadFile;
            try {
                String filePath = fileUploadPath+getNewFileName(file);
                uploadFile = new File(filePath);
                file.transferTo(uploadFile);
                postFile.setFilePath(filePath);
                postFile.setActive(1);
                postFile.setFileUrl(getFileUrl(uploadFile));
            }catch (IOException e) {
                e.printStackTrace();

            }




        return true;
    }

    /**
     * 用于给文件重命名
     * @param multipartFile
     * @return
     */
    private static String getNewFileName(MultipartFile multipartFile){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStamp = simpleDateFormat.format(new Date());

        String multipartFileName = multipartFile.getOriginalFilename();
        String fileSuffix = multipartFileName.substring(multipartFileName.lastIndexOf(".") + 1);
        String fileName = multipartFileName.substring(0,multipartFileName.lastIndexOf("."));

        return fileName + "-" + timeStamp + "." + fileSuffix;
    }
    private static String getFileUrl(File file){
        System.out.println("IP:"+IP+"FILEMAP:"+FILE_MAP+ File.separator+"fileName"+file.getName());
        return IP+FILE_MAP+ File.separator+file.getName();
    }
}
