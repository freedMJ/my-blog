package com.lmj.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constant {
    @Value("${image.file}")
    private  String IMAGE_FILE ;

    public Constant() {
    }

    public  String getImageFile() {
        return IMAGE_FILE;
    }

    public  void setImageFile(String imageFile) {
        IMAGE_FILE = imageFile;
    }

}
