package com.cloud.alibaba.controller;

import com.cloud.alibaba.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SleepController {

    private SleepService sleepService;

    @Autowired
    public void setSleepService(SleepService sleepService) {
        this.sleepService = sleepService;
    }

    @GetMapping(path = "/sleep/{second}")
    public String sleep(@PathVariable("second") Long second){
        return sleepService.sleep(second);
    }

}
