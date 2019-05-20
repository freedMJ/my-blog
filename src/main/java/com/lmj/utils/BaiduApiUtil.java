package com.lmj.utils;


import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

public class BaiduApiUtil {
    //设置APPID/AK/SK
    public static final String APP_ID = "16288908";
    public static final String API_KEY = "YeyGVz9bFTBNrOfCyVEGT33T";
    public static final String SECRET_KEY = "hD4MGSGzq4cgysyYtYWgp3KmuGZ7Ejf8";

    public static String  imageToTxt(String path,String imageName) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("probability", "true");
        // 参数为本地路径
        String image = path+imageName;
        JSONObject res = client.basicAccurateGeneral(image, options);
        return res.toString(2);
    }

}
