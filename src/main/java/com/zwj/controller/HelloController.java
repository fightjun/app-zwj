package com.zwj.controller;

import com.zwj.util.Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HelloController {

    private static int count = 1;

    @RequestMapping(value = "/zlj")
    public ModelAndView helloWorld2(HttpServletRequest request) {
        String ip = Utils.getIpAddr(request);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMdd hh:mm:ss");
        System.out.println("当前时间：" + simpleDateFormat.format(date));
        System.out.println("服务器第"+ count +"次请求，ip地址："+ip);
        count++;
        ModelAndView mv = new ModelAndView("forward:/smile.html");
//        return "<body  width='500px'><h1>hello, 你来了, 悄悄告诉你，有人喜欢你哦。</h1>" +
//                "<h2>\n讲个笑话 请问：五四运动的导火索是什么？\n" +
//                "答案：五一只放三天假.....</h2><audio src='001.mp3' autoPlay='autoPlay' controls='controls' preload='preload'></audio></body>";
        return mv;
    }
}
