package com.ciberdix.user.controllers;

import com.ciberdix.user.models.User;
import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roberto Chajin Ortiz
 */
@RestController
public class UserController {
   private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

   @RequestMapping("/testuser")
   @ResponseBody
   public HttpEntity<User> getTestText(@RequestHeader(value = "Authorization") String authorizationHeader, Principal currentUser) {

      LOG.info("UserService: User={}, Auth={}", currentUser.getName(), authorizationHeader);

      User user = new User("Carl", "Tester", "carli", "carl.tester@example.com");

      return new ResponseEntity<>(user, HttpStatus.OK);
   }    
}
