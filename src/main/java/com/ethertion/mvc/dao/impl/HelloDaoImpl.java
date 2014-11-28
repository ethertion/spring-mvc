/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethertion.mvc.dao.impl;

import com.ethertion.mvc.dao.HelloDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amiguel
 */
@Repository
public class HelloDaoImpl implements HelloDao{
    
    private static final Logger logger = Logger.getLogger(HelloDaoImpl.class);

    @Override
    public String getHello() {
        logger.debug("Hello World!!!");
        return "Hello World!!!";
    }
    
}