package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMysql {

    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String index() {

        String sql = "SELECT username FROM user WHERE id=?";

        // 通过jdbcTemplate查询数据库
        String mobile = (String)jdbcTemplate.queryForObject(
                sql, new Object[] { 1 }, String.class);

        return "Hello " + mobile;
    }
}