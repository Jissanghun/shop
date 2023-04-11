package com.shop.ncp;

import com.shop.util.CFRCUtil;
import com.shop.util.CFRUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CFRTests {

    @Value("${imglocation}")
    String imgpath;
    @Test
    void contextLoads() throws Exception {
        String imgname = "ma02.jpg";
        String result = CFRUtil.getText(imgpath, imgname);
        System.out.println(result);

        Map<String,String> map = CFRUtil.getFaceInfo(result);

        System.out.println(map.get("gender"));
        System.out.println(map.get("age"));
        System.out.println(map.get("emotion"));
        System.out.println(map.get("pose"));
    }

}
