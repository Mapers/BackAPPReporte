package com.cloudsrcsoft.reportes.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsrcsoft.reportes.security.JwtTokenUtil;
import com.cloudsrcsoft.reportes.security.JwtUser;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.OPTIONS)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = jwtTokenUtil.getJwtFromRequest(request);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        log.debug("username" + username);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }
}
