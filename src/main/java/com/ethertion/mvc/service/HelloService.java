/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethertion.mvc.service;

import com.ethertion.mvc.model.Hello;

/**
 *
 * @author amiguel
 */
public interface HelloService {
    
    public String sayHello(Long id);
    public String postHello(Hello hello);
    
}
