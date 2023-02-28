package com.example.s3testproject.service;

import com.example.s3testproject.entity.Diary;
import com.example.s3testproject.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;

    @Autowired
    private UploadService s3Uploader;
    @Transactional
    public String save(MultipartFile image, Diary diary) throws IOException {
        if(!image.isEmpty()){
            String storedFileName = s3Uploader.upload(image, "images");
            diary.setImageUrl(storedFileName);
        }
        diaryRepository.save(diary);
        return "저장됨";
    }

    @Transactional
    public List getall() {
        return diaryRepository.findAllBy();
    }
}
