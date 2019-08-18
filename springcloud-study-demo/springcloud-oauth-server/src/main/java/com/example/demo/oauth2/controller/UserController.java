package com.example.demo.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {
 /*   @Autowired
    private BaseUserService baseUserService;
*/
   /* @PostMapping("/saveUser")
   public  void saveUser(BaseUser baseUser){
        baseUserService.saveUser(baseUser);
   }*/

   @GetMapping("/getUser")
   public Principal user(Principal user){
       return user;
   }

}
