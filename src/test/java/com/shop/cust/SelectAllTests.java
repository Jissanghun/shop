package com.shop.cust;

import com.shop.dto.CustDTO;
import com.shop.service.CustService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SelectAllTests {
	@Autowired
	CustService custService;
	@Test
	void contextLoads() {
		List<CustDTO> list = null;
		try {
			list = custService.get();
			for(CustDTO c:list){
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}
