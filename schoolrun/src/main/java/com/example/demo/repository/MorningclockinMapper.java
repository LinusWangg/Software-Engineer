package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Morningclockin;

public interface MorningclockinMapper {
    int insert(Morningclockin record);

    int insertSelective(Morningclockin record);
    
    Morningclockin findlastsucceed(String clockin_stuid, String clockin_stuschool, short succeed);
    
    List<Morningclockin> getmine(String clockin_stuid, String clockin_stuschool);
    
    List<Morningclockin> getall(String clockin_stuschool, int offset);
}