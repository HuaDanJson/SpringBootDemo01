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
@RequestMapping("/user")
class UserControl {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoControl userInfoControl;

    @GetMapping("/getAllUser")
    public List<UserInfo> getAllUser() {
        return userInfoControl.findAll();
    }

    @GetMapping("/getUserInfo/{userId}")
    public Optional<UserInfo> getUserInfo(@PathVariable Integer userId) {
        return userInfoControl.findById(userId);
    }

    @PostMapping("/register")
    public UserInfo register(@RequestBody UserInfo userInfo) {
        return userInfoControl.save(userInfo);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserInfo userInfo) {
        if (userInfo != null) {
            List<UserInfo> userInfoList = userInfoControl.findAllByUsername(userInfo.getUsername());
            if (userInfoList != null && userInfoList.size() > 0) {
                UserInfo userInfo1 = userInfoList.get(0);
                if (userInfo1.getPwd().equals(userInfo.getPwd())) {
                    return "success";
                }
            }
        }
        return "failed";
    }

    @PostMapping("/update")
    public UserInfo update(@RequestBody UserInfo userInfo) {
        return userInfoControl.save(userInfo);
    }
}
