package com.baizhi.util;

import com.baizhi.entity.FileParam;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2018/5/31.
 */
public class UploadUtil {
    public static final String FILE = "File";
    public static final String IMG = "IMG";
    public static final String VIDEO = "VIDEO";
    public static final String AUDIO = "AUDIO";
    public static FileParam uploadFile(MultipartFile multipartFile, HttpServletRequest request,String type){
        //项目的根路径
        String projectPath = request.getSession().getServletContext().getRealPath("/");
        File file =new File(projectPath);
        //web项目的路径
        String webappsPath = file.getParent();
        //创建上传文件夹
        File uploadPath=new File(webappsPath+"/file");
        String url=null;
        if(!uploadPath.exists()){
            uploadPath.mkdir();
        }
        //根据类别创建不同的子文件夹  分类管理
        if(type.equals(FILE)){
            //上传文件夹的路径
            uploadPath=new File(webappsPath+"/file"+"/doc");
            url="/file/doc";
        }else if(type.equals(IMG)){
            uploadPath=new File(webappsPath+"/file"+"/img");
            url="/file/img";
        }else if (type.equals(VIDEO)){
            uploadPath=new File(webappsPath+"/file"+"/video");
            url="/file/video";
        }else if (type.equals(AUDIO)){
            uploadPath=new File(webappsPath+"/file"+"/audio");
            url="/file/audio";
        }
        if(!uploadPath.exists()){
            uploadPath.mkdir();
        }
        //获取原始文件名  （包含后缀名）
        String oldFilename = multipartFile.getOriginalFilename();
        //获取后缀名   (根据文件名获取后缀名)
        String extension = FilenameUtils.getExtension(oldFilename);
        //保证文件不被覆盖  文件重命名
        String  newName= UUID.randomUUID().toString()+"."+extension;

        //将文件上传到指定的文件夹
        try {
            multipartFile.transferTo(new File(uploadPath.getPath(),newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileParam(url+"/"+newName,oldFilename);
    }
}











