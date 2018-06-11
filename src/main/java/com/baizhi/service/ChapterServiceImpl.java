package com.baizhi.service;

import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.FileParam;
import com.baizhi.util.AudioUtil;
import com.baizhi.util.FileSizeUtil;
import com.baizhi.util.UploadUtil;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/4.
 */
@Service
@Transactional
public class ChapterServiceImpl implements  ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;
    public void insert(MultipartFile file, Chapter chapter, HttpServletRequest request) {
        //将文件存储在文件服务器
        FileParam fileParam = UploadUtil.uploadFile(file,request,UploadUtil.AUDIO);
        //获取音频长度
        File filePath=new File("F:\\apache-tomcat-7.0.67\\webapps"+fileParam.getUrl());
        try {
            String duration=AudioUtil.getAudioLength(filePath);
          //设置时长
            chapter.setDuration(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String size=FileSizeUtil.getFileSize(file.getSize());//将字节（long）转化为MB
        chapter.setC_size(size);//设置文件大小
        chapter.setUploadDate(new Date());//设置上传时间
        //设置下载路径
        chapter.setDownPath(fileParam.getUrl());
        chapterDAO.insert(chapter);
    }
}
