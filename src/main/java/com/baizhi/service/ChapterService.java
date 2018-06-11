package com.baizhi.service;

import com.baizhi.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
public interface ChapterService {
    void insert(MultipartFile file, Chapter chapter, HttpServletRequest request);

}
