package com.example.demo.repository;

import com.example.demo.model.Codemodel;
import java.util.List;

public interface CodemodelMapper {
    int insert(Codemodel record);

    int insertSelective(Codemodel record);
    
    List<Codemodel> getallcode();
    
    
}