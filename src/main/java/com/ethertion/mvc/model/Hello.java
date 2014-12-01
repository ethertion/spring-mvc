/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethertion.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author amiguel
 */
@Entity 
@Table (name="Hello") 
public class Hello {
    
    private Long id;
    private String hello;

    @Id 
    @GeneratedValue 
    public Long getId() { 
        return id; 
    } 

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column (name="hello") 
    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    } 
        
}
