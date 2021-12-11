package com.parklot.service.impl;

import com.parklot.service.SearchService;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceImplTest {
    @Autowired
    private SearchService searchService;

    @Test
    public void Tets1(){
        String result = searchService.getSearchContent("手机");
        System.out.println(result);
    }
}