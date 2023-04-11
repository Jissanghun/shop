package com.shop.frame;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface MyMapper<K,V> {
    // CRUD
    public void insert(V v) throws Exception;
    public void update(V v) throws Exception;
    public void delete(K k) throws Exception;
    public V select(K k) throws Exception;
    public List<V> selectall() throws Exception;
}
