package com.shop.ncp;

import com.shop.util.ChatBotUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class chatbotTests {

@Test
void contextLoads() {
	String str = "니이름이뭐니";
	String result = null;
	try {
		result = ChatBotUtil.chat(str);
	} catch (IOException e) {
		throw new RuntimeException(e);
	}
	System.out.println(result);
}
}
