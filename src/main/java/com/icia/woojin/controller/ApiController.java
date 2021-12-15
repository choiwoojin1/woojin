package com.icia.woojin.controller;

import com.icia.woojin.dto.ApiDTO;
import com.icia.woojin.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApiController {

    private ModelAndView mav = new ModelAndView();

    @Autowired
    private ApiService svc;


    @RequestMapping(value = "/imap", method = RequestMethod.GET)
    public String imap() {
        return "imap";
    }

    // insertMap
    @RequestMapping(value = "/insertMap", method = RequestMethod.GET)
    public ModelAndView insertMap(@ModelAttribute ApiDTO api){
        mav =svc.insertMap(api);
        return mav;
    }


}