package com.shop.mapper;

import com.github.pagehelper.Page;
import com.shop.dto.ShopDTO;
import com.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopMapper extends MyMapper<String, ShopDTO> {
    public List<ShopDTO> search(String txt) throws Exception;
    Page<ShopDTO> getPage() throws Exception;
}

