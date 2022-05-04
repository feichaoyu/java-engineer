package com.example.mapper;

import com.example.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountryMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAllByStatementId() {
        SqlSession sqlSession = getSqlSession();
        List<Country> countryList = sqlSession.selectList("com.example.mapper.CountryMapper.selectAll");
        printCountryList(countryList);
        sqlSession.close();
    }

    @Test
    public void testSelectAllByMapper() {
        SqlSession sqlSession = getSqlSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        List<Country> countryList = mapper.selectAll();
        printCountryList(countryList);
        sqlSession.close();
    }

    @Test
    public void testSelect() {
        SqlSession sqlSession = getSqlSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        Country country = mapper.selectBy(1L, "中国", "CN");
        printCountryList(Collections.singletonList(country));
        sqlSession.close();
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }
}
