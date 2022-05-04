package com.example.mapper;

import com.example.model.Country;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountryMapper {
    List<Country> selectAll();

    Country selectBy(@Param("id") Long id, @Param("name") String name, @Param("code") String code);
}
