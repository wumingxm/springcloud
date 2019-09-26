package com.alibaba.nacos.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("config")
public class ConfigController {

    @Autowired
    private ApplicationContext applicationContext;

/*    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;*/

   /* @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public boolean get() {
        //applicationContext.publishEvent(new StudentnEvent());
        return useLocalCache;
    }*/
}
