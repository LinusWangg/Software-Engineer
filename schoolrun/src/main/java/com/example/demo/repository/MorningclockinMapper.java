package com.example.demo.repository;

import com.example.demo.model.Morningclockin;

public interface MorningclockinMapper {
    int insert(Morningclockin record);

    int insertSelective(Morningclockin record);
    
    Morningclockin findlastsucceed(String clockin_stuid, String clockin_stuschool, short succeed);
}