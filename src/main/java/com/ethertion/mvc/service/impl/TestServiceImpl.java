/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethertion.mvc.service.impl;

import com.ethertion.mvc.service.TestService;
import org.apache.log4j.Logger;

/**
 *
 * @author amiguel
 */
public class TestServiceImpl implements TestService{
    
    private static final Logger logger = Logger.getLogger(TestServiceImpl.class);

    @Override
    public void test() {
        logger.debug("Testing ...");
    }
    
}
