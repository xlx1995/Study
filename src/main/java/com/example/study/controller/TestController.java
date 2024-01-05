package com.example.study.controller;

import com.example.study.springtx.TestTxService;
import com.example.study.springtx.db.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : xlx
 * @Description :
 * @Date: 2023/9/26
 */
@RestController
public class TestController {

    @Autowired
    private TestTxService testTxService;

    @GetMapping
    @RequestMapping("/test")
    public void test(){
        System.out.println("hello");
    }

    @GetMapping
    @RequestMapping("/testTx")
    public void testTx(){
        testTxService.testTx();
    }

    @GetMapping
    @RequestMapping("/query")
    public UserDO query(Integer id){
        UserDO userDO = testTxService.query(id);
        return userDO;
    }
}
