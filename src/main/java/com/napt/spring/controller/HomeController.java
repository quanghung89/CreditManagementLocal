package com.napt.spring.controller;

import com.napt.spring.dao.service.UserDaoService;
import com.napt.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by napt2017 on 4/6/2017.
 */

@RestController
@RequestMapping("/home")
@ComponentScan("com.napt.spring.*")
public class HomeController {

    @Autowired
    private UserDaoService userDaoService;
    //https://www.youtube.com/watch?v=Iv1SvDGtne0
    //https://www.youtube.com/watch?v=XrBdRWFLQOY

    @RequestMapping(value="/findUser",method = RequestMethod.GET)
    public ResponseEntity<User> home(){
        User user = userDaoService.findById(1L);
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/hkt",method = RequestMethod.GET)
    public ResponseEntity<String> hkt(){
        return ResponseEntity.ok("Napt");
    }
}
