package com.websystique.springmvc.controller;


import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by pengyuntao on 16/10/12.
 */
@Controller
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "yuntao");
        return "hello";
    }
    //    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
//    public String test(){
//        return "hello1";
//    }
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)

    public void hello2(HttpServletRequest request, HttpServletResponse response, MultipartFile file) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.write(request.getParameter("i1"));
    }
    @RequestMapping(value = "test",method=RequestMethod.GET)
    public String test(){
        return "/Hello/test";
    }

}
