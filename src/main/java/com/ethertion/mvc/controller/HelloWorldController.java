package com.ethertion.mvc.controller;

import com.ethertion.mvc.model.Hello;
import com.ethertion.mvc.service.HelloService;
import com.ethertion.mvc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
    
    public static Long DEFAULT_HELLO_ID = 1L;
    
    @Autowired
    private HelloService helloService;    
    @Autowired
    private TestService testService;
   
   
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String hello(ModelMap model) {
        
        String hello = helloService.sayHello(DEFAULT_HELLO_ID);
        model.addAttribute("msg", hello);
        testService.test();

        return "index";
    }
    
    @RequestMapping(value="/post", method = RequestMethod.POST)
    public String post(@ModelAttribute("hello") Hello hello, ModelMap model) {
        
        String res = helloService.postHello(hello);
        String msg = (res!=null) ? "Hello posted successfully: " + res : "Hello could not be posted.";
        model.addAttribute("msg", msg);
        testService.test();

        return "index";
    }

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }    

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
    

}
