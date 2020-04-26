package org.wuy.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ApplicationController {
    @RequestMapping("hello")
    public String testMapping(){
        return "hhhhhhhhh";

    }
}