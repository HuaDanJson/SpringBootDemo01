package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hello")
public class HelloControl {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    static Logger logger = Logger.getLogger(HelloControl.class);

//    //注解获取YML中的数据 yml 为配置文件
//    @Value("${cupSize}")
//    public String cupSize;
//
//    @Value("${age}")
//    public Integer age;
//
//    @Value("${content}")
//    public String content;
    /**
     * Control 控制器      RestController == Controller + ResponseBody
     */

//    @Autowired
//    private Girl girls;

    @Autowired
    private DBGirl dbGirl;

    @Autowired
    private GirlService girlService;

    @Autowired
    private UserInfoControl userInfoControl;

    @GetMapping("/say")
    public String say() {
        return "Say";
    }

    @GetMapping("/say2")
    public Girl say2() {
        Girl girl = new Girl();
        girl.setAge(19);
        girl.setCupSize("FF");
        return dbGirl.save(girl);
    }

    @GetMapping("/say3")
    public List<Girl> say3() {
        return dbGirl.findAll();
    }

    @GetMapping("/say4")
    public Optional<Girl> say4() {
        return dbGirl.findById(9);
    }

    @GetMapping("/say5")
    public List<Girl> say5() {
        return dbGirl.findByAge(19);
    }

    @GetMapping("/say6")
    public List<Girl> say6() {
        return dbGirl.findByAge(18);
    }

    @GetMapping("/say7")
    public List<Girl> say7() {
        return dbGirl.findByCupSize("FF");
    }

    @GetMapping("/say8")
    public List<Girl> say8() {
        return dbGirl.findByCupSize("AAA");
    }

    @PostMapping("/girls/two")
    public String insertTwoGirs() {
        return girlService.insertTwo();
    }

    @GetMapping("/getContent/{id}")
    public String getContent(@PathVariable Integer id) {

//        logger.info("getContent id = "+id);

        logger.info("11111   id = " + id);
        logger.debug("11");
        logger.error("1111");


        return "GetContent  id = " + id;
    }

    //Controller 处理器  Controller注解

    /**
     * @PathVariable:=获取URL中的数据
     * @RequestParam ：获取请求参数的值
     * @GetMapping ：组合注解
     */

    @PostMapping("/register")
    public String register(@RequestBody TestBoidy requestBody) {

        logger.info("HelloControl 00 register = " + requestBody);
//        userInfoControl.save(userInfo);
        return "Register success";
    }

    @PostMapping("/register2")
    public UserInfo register2(@RequestBody UserInfo userInfo) {

        logger.info("HelloControl 111 UserInfo = " + userInfo);

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUsername(userInfo.getUsername());
        userInfo1.setPwd(userInfo.getPwd());
        userInfoControl.save(userInfo1);

//        userInfoControl.save(userInfo);
        return userInfoControl.save(userInfo1);
    }

    @PostMapping("/register3")
    public UserInfo register3(@RequestBody UserInfo userInfo) {
        logger.info("HelloControl 222 UserInfo = " + userInfo);
//        userInfoControl.save(userInfo);
        return userInfoControl.save(userInfo);
    }

}
