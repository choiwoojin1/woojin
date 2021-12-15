package com.icia.woojin.service;

import com.icia.woojin.dao.ApiDAO;
import com.icia.woojin.dto.ApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class ApiService {

    private ModelAndView mav = new ModelAndView();

    @Autowired
    private ApiDAO dao;

    public ModelAndView insertMap(ApiDTO api) {
        int result = dao.insertMap(api);

        if(result>0){
            mav.setViewName("redirect:/kmap3");
        }else{
            mav.setViewName("index");
        }
        return mav;
    }


}
