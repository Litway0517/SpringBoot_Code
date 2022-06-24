package com.litway.controller;


import com.litway.controller.utils.R08;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/image")
public class ImageController {

    @PostMapping("/test/upload")
    public R08 upload(ModelAndView file) {
        R08 result = new R08();
        System.out.println(file);

        return result;

    }

    @PostMapping("/test/addImage")
    public R08 upload(MultipartFile file) {
        R08 result = new R08();
        System.out.println("名称" + file.getOriginalFilename());
        System.out.println("大小" + file.getSize());

        String originalFilename = file.getOriginalFilename();

        try {
            file.transferTo(new File("F:\\IDEA-Java\\12-HM-SpringBoot2-T\\SpringBoot_Code\\springboot_08_SSMP\\src\\main\\resources\\static\\images\\" + originalFilename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(file);



        return result;

    }
}
