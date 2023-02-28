package com.example.s3testproject.controller;

import com.example.s3testproject.entity.Diary;
import com.example.s3testproject.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DirayController {
    private final DiaryService diaryService;

    @PostMapping("/diary")
    public String saveDiary(@RequestParam(value="image")MultipartFile image, Diary diary) throws IOException{
        System.out.println(image);
        System.out.println(diary);
        return diaryService.save(image, diary);
    }
    @GetMapping("/diary")
    public List getDiary(){
        return diaryService.getall();
    }

}
