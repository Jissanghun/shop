package com.shop.carts;

import com.shop.dto.CartsDTO;
import com.shop.dto.CustDTO;
import com.shop.service.CartsService;
import com.shop.service.CustService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpdateTests {
	@Autowired
	CartsService service;
	@Test
	void contextLoads() {
		CartsDTO obj = new CartsDTO(100,null,100,10,null);
		try {
			service.modify(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 시 오류");
		}
	}

}
