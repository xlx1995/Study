package com.example.study.springtx.service;

import com.example.study.springtx.ex.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author : xlx
 * @Description :
 * @Date: 2023/9/27
 */
@Component
@Slf4j
public class TransactionService {

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void testRequired(TransactionCommand command) {
        try {
            command.run();
        }catch (Exception e){
            throw new BusinessException(e.getMessage(),e);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public void testSupported(TransactionCommand command) {
        try {
            command.run();
        }catch (Exception e){
            throw new BusinessException(e.getMessage(),e);
        }
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
    public void testNotSupported(TransactionCommand command) {
        try {
            command.run();
        }catch (Exception e){
            throw new BusinessException(e.getMessage(),e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void testRequiredNew(TransactionCommand command) {
        try {
            command.run();
        }catch (Exception e){
            throw new BusinessException(e.getMessage(),e);
        }
    }

    @Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
    public void testNested(TransactionCommand command) {
        try {
            command.run();
        }catch (Exception e){
            throw new BusinessException(e.getMessage(),e);
        }
    }

    public static void main(String[] args) {
        Set<Long> set = new HashSet<>();
        Map<Long,Long> map = new HashMap<>();
        map.put(1L,1L);
        set = map.keySet();
        List<Long> list = new ArrayList<>();
        list.add(1L);
        set.addAll(list);
    }

}
