/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethertion.mvc;

import com.ethertion.mvc.dao.impl.HelloDaoImpl;
import com.ethertion.mvc.model.Hello;
import com.ethertion.mvc.service.impl.HelloServiceImpl;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author amiguel
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    Hello hello;
    
    @Spy
    LinkedList spy;

    @InjectMocks
    HelloServiceImpl helloService;
    
    @Mock
    HelloDaoImpl helloDao;

    @Test
    public void testHello() {
        
        /**
         * void methods do nothing
         */
        
        String res = "";
       
        //when
        when(helloDao.getHello(0L)).thenReturn("r0");  
        //doReturn("r0").when(helloDao).getHello(0L);
        res = helloService.sayHello(0L);        
        assertEquals("r0", res);
        
        //verify
        //doReturn(Object),doThrow(Throwable),doThrow(Class),doAnswer(Answer),doNothing()
        
        //doThrow(RuntimeException.class).when(hello).setHello(res);
        doCallRealMethod().when(hello).setHello(res);
        verify(helloDao).getHello(0L);        
        hello.setHello(res);        
        verify(hello).setHello(res);
        hello.setHello(res);      
        verify(hello, times(2)).setHello(res);  
        when(hello.getHello()).thenReturn("r0");
        assertEquals("r0", hello.getHello());
                       
        //let's make clear() do nothing
        doNothing().when(spy).clear();
        spy.add("one");
        //clear() does nothing, so the list still contains "one"
        spy.clear();
        assertEquals(spy.size(), 1);
        
        

    }

}
