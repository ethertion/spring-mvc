/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethertion.mvc.service.impl;

import com.ethertion.mvc.dao.HelloDao;
import com.ethertion.mvc.model.Hello;
import com.ethertion.mvc.service.HelloService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author amiguel
 */
@Service
public class HelloServiceImpl implements HelloService{
    
    private static final Logger logger = Logger.getLogger(HelloServiceImpl.class);
    
    @Autowired
    private HelloDao helloDao;

    @Override
    public String sayHello(Long id) {
        String res = helloDao.getHello(id);
        logger.debug(res);
        return res;
    }
    
    @Override
    public String postHello(Hello hello) {
        String res = null;
        try{
            res = helloDao.postHello(hello);
        }catch(Exception e){
            logger.error (e);
        }
        logger.debug(res);
        return res;
    }

    public HelloDao getHelloDao() {
        return helloDao;
    }

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }
    
    
    
}
