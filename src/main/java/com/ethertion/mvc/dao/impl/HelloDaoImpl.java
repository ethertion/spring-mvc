/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethertion.mvc.dao.impl;

import com.ethertion.mvc.dao.HelloDao;
import com.ethertion.mvc.model.Hello;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amiguel
 */
@Repository
public class HelloDaoImpl extends GenericDaoImpl implements HelloDao  {
    
    public static String DEFAULT_HELLO = "Hello World!!!";
    private static final Logger logger = Logger.getLogger(HelloDaoImpl.class);
    
    @Override
    public String getHello(Long id) {        
        
        String res = DEFAULT_HELLO;
                
        Hello hello = (Hello)this.getSessionFactory().openSession().get(Hello.class, id);        
        if (hello!=null){
            res = hello.getHello();
        }
        logger.debug(res);
        return res;
    }
    
    @Override
    public String postHello(Hello hello) throws Exception{
        String res = null;
        try{           
            this.getSessionFactory().openSession().save(hello);
            res = hello.getHello();
        }catch(HibernateException e){
            logger.error (e);
            throw new Exception (e);
        }
        return res;
    }
    
}