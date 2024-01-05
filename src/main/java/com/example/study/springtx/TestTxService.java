package com.example.study.springtx;

import com.example.study.springtx.db.dataobject.UserDO;
import com.example.study.springtx.service.TransactionService;
import com.example.study.springtx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author : xlx
 * @Description :
 * @Date: 2023/9/27
 */
@Component
@Slf4j
public class TestTxService {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;


    public void testTx(){
        UserDO userA = new UserDO();
        userA.setName("a");
        UserDO userB = new UserDO();
        userB.setName("b");
//        UserDO c = new UserDO();
//        c.setName(null);
//        List<UserDO> list = Arrays.asList(c);
//        list.stream().forEach(i -> System.out.println(i.getName().toString()));
        transactionService.testRequired(() -> {
//            System.out.println(c.getName());
            int i = userService.testWithOutTX(userA);
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

            }
            userService.testRequiredNew(userB);
        });
    }

    public UserDO query(Integer id) {
        return userService.queryById(id);
    }
}
