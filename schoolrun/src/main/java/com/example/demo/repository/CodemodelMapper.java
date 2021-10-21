package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Codemodel;

public interface CodemodelMapper {
    int insert(Codemodel record);

    int insertSelective(Codemodel record);

	List<Codemodel> getallcode(int offset);

	Codemodel findbytime(int month, int day, int hour, int minute);
}