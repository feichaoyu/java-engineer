package com.example.mapper;

import com.example.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testSelectBy1() {
        SqlSession sqlSession = getSqlSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        Country country = mapper.selectBy1(1L);
        printCountryList(Collections.singletonList(country));
        sqlSession.close();
    }

    @Test
    public void testSelectBy2() {
        SqlSession sqlSession = getSqlSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("id", 1L);
        paramsMap.put("name", "中国");
        paramsMap.put("code", "CN");
        Country country = mapper.selectBy2(paramsMap);
        printCountryList(Collections.singletonList(country));
        sqlSession.close();
    }

    @Test
    public void testSelectBy3() {
        SqlSession sqlSession = getSqlSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        Country country = mapper.selectBy3(1L, "中国", "CN");
        printCountryList(Collections.singletonList(country));
        sqlSession.close();
    }

    @Test
    public void testSelectBy4() {
        SqlSession sqlSession = getSqlSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        Country country = mapper.selectBy4(1L, "中国", "CN");
        printCountryList(Collections.singletonList(country));
        sqlSession.close();
    }

    @Test
    public void testSelectBy5() {
        SqlSession sqlSession = getSqlSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        Country params = new Country();
        params.setId(1L);
        params.setCountryname("中国");
        params.setCountrycode("CN");
        Country country = mapper.selectBy5(params);
        printCountryList(Collections.singletonList(country));
        sqlSession.close();
    }


    @Test
    public void testSelectBy6() {
        SqlSession sqlSession = getSqlSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        Country params = new Country();
        params.setId(1L);
        params.setCountryname("中国");
        params.setCountrycode("CN");
        Country country = mapper.selectBy6(params);
        printCountryList(Collections.singletonList(country));
        sqlSession.close();
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }
}
