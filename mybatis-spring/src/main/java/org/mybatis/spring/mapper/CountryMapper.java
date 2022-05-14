package org.mybatis.spring.mapper;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.model.Country;

import java.util.List;

public interface CountryMapper {
    List<Country> selectList();

    Country selectOne(@Param("id") Long id, @Param("name") String name, @Param("code") String code);
}
