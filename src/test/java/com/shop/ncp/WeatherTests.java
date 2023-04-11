package com.shop.ncp;

import com.shop.util.ChatBotUtil;
import com.shop.util.WeatherUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class WeatherTests {

    @Test
    void contextLoads() throws Exception {
        String weatherInfo = WeatherUtil.getWeatherInfo("159");
        System.out.println(weatherInfo);
    }
}
