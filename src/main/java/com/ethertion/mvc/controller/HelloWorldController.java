package com.ethertion.mvc.controller;

import com.ethertion.mvc.service.HelloService;
import com.ethertion.mvc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
    
    @Autowired
    private HelloService helloService;    
    @Autowired
    private TestService testService;
   
   
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String hello(ModelMap model) {

        model.addAttribute("msg", "Hello World");
        helloService.sayHello();
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
