package com.shop.mapper;

import com.github.pagehelper.Page;
import com.shop.dto.MallDTO;
import com.shop.dto.ShopDTO;
import com.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MallMapper extends MyMapper<String, MallDTO> {
    public List<MallDTO> search(String txt) throws Exception;
    Page<MallDTO> getPage() throws Exception;
}

