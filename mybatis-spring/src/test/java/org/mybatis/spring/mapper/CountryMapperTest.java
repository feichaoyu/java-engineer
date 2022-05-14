package org.mybatis.spring.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.config.MybatisSpringConfiguration;
import org.mybatis.spring.model.Country;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisSpringConfiguration.class)
public class CountryMapperTest {

    @Resource
    private CountryMapper countryMapper;

    @Test
    public void selectList() {
        List<Country> countryList = countryMapper.selectList();
        printCountryList(countryList);
    }

    @Test
    public void selectOne() {
        Country country = countryMapper.selectOne(1L, "中国", "CN");
        printCountryList(Collections.singletonList(country));
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }
}
