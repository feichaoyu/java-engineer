package com.example.mapper;

import com.example.model.Country;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CountryMapper {
    List<Country> selectAll();

    Country selectBy1(Long id);

    Country selectBy2(Map<String, Object> paramsMap);

    Country selectBy3(Long id, String name, String code);

    Country selectBy4(@Param("id") Long id, @Param("name") String name, @Param("code") String code);

    Country selectBy5(Country country);

    Country selectBy6(@Param("country") Country country);
}
