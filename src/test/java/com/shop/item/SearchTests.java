package com.shop.item;

import com.shop.dto.ItemDTO;
import com.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SearchTests {
	@Autowired
	ItemService service;
	@Test
	void contextLoads() {
		List<ItemDTO> list = null;
		try {
			list = service.search("바");
			for(ItemDTO obj:list){
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}
