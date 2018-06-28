package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private DBGirl dbGirl;

    @Transactional
    public String insertTwo() {
        Girl girl = new Girl();
        girl.setCupSize("GF");
        girl.setAge(56);
        dbGirl.save(girl);

        Girl girl2 = new Girl();
        girl2.setCupSize("A");
        girl2.setAge(26);
        dbGirl.save(girl2);

        return "insert Sucees";
    }
}
