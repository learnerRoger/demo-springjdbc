package com.example.test;

import com.example.domain.Paper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate(){
        //jdbcTemplate.update("update paper set ppr = ? where pno = ?",19.0,"000712");
        jdbcTemplate.update("delete from paper where pno = ?","000712");
    }

    @Test
    public void testQuery(){
        List<Paper> paperList = jdbcTemplate.query("select * from paper", new BeanPropertyRowMapper<Paper>(Paper.class));
        System.out.println(paperList);
    }

    @Test
    public void testQueryBy(){
        Paper paper = jdbcTemplate.queryForObject("select * from paper where pno = ?", new BeanPropertyRowMapper<Paper>(Paper.class), "000002");
        System.out.println(paper);
    }

    @Test
    public void testQueryCount(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from paper", Long.class);
        System.out.println(aLong);
    }

}
