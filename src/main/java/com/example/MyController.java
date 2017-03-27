package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.xml.ws.Response;

/**
 * Created by RENT on 2017-03-25.
 */
@Controller
public class MyController {
    @Autowired
    private MyService myService;

//    @PostConstruct
//    public void setup() {
//        System.out.println("Service: " + myService);
//    }

//    @RequestMapping
//    @ResponseBody
//    public String hello() {
//        return "Hello stranger";
//    }

    @RequestMapping("/helloRp")
    @ResponseBody
    public String helloRp(@RequestParam String name) {
        return "Hello" + name;
    }

    @RequestMapping("/helloRp2")
    @ResponseBody
    public String helloRp2(@RequestParam("firstName") String name) {
        return "Hello" + name;
    }


    @RequestMapping("/helloRp3")
    @ResponseBody
    public String helloRp3(@RequestParam String name, @RequestParam String surname) {
        return "Hello" +" "+ name+" "+surname;
    }

    @RequestMapping("/helloRpT")
    @ResponseBody
    public String helloRpT(@RequestParam(required = false,defaultValue = "Gall") String name, @RequestParam(required = false,defaultValue = "Anonim") String surname) {
        return "Hello" +" "+ name+" "+surname;
    }

    @RequestMapping("/helloRpP/{name}")
    @ResponseBody
    public String helloRpP(@PathVariable String name) {
        return "Hello" +" "+ name;
    }

    @RequestMapping("/point")
    @ResponseBody
    public Point point(){
        Point point=new Point();
        point.setX(12);
        point.setY(14);
        return point;
    }
    @RequestMapping("/point2/{x}")
    @ResponseBody
    public Point point2(@PathVariable int x, @RequestParam int y){
        Point point=new Point();
        point.setX(x);
        point.setY(y);
        return point;
    }

    @RequestMapping("/status")
    @ResponseBody
    public ResponseEntity<String> status(){
        return new ResponseEntity<String>("response message", HttpStatus.NOT_FOUND);

    }


    @RequestMapping(method = RequestMethod.POST,value = "/createPoint")
    @ResponseBody
    public void createPoint(@RequestBody Point point){
        System.out.println(point);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/createPoint2")
    @ResponseBody
    public String createPoint2(@RequestBody Point point){
        System.out.println(point);
        return "Point created";
    }


}
