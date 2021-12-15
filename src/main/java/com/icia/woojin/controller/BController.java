package com.icia.woojin.controller;

import com.icia.woojin.dto.BOARD;
import com.icia.woojin.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class BController {

    @Autowired
    private BService bsvc;

    private ModelAndView mav = new ModelAndView();


    // writeForm : 글쓰기 페이지로 이동
    @RequestMapping(value="/bwriteForm", method = RequestMethod.GET)
    public String writeForm(){
        return "bwrite";
    }

    // bWrite : 글작성
    @RequestMapping(value="/bWrite", method = RequestMethod.POST)
    public ModelAndView bWrite(@ModelAttribute BOARD board) throws IOException {
        mav = bsvc.bWrite(board);
        return mav;
    }

    // bList : 글목록보기
    @RequestMapping(value="/bList", method = RequestMethod.GET)
    public ModelAndView bList(){
        mav = bsvc.bList();
        return mav;
    }

    // bView : 게시글 상세보기
    @RequestMapping(value="/bView", method = RequestMethod.GET)
    public ModelAndView bView(@RequestParam("bNo")int bNo){
        mav = bsvc.bView(bNo);
        return mav;
    }

    // bModiForm : 수정페이지로 이동
    @RequestMapping(value="bModiForm", method = RequestMethod.GET)
    public ModelAndView bModiForm(@RequestParam("bNo") int bNo){
        mav = bsvc.bModiForm(bNo);
        return mav;
    }

    // bModify : 게시글 수정
    @RequestMapping(value="/bModify", method = RequestMethod.POST)
    public ModelAndView bModify(@ModelAttribute BOARD board) throws IOException {
        mav = bsvc.bModify(board);
        return mav;
    }

    // bDelete : 게시글 삭제
    @RequestMapping(value="/bDelete", method = RequestMethod.GET)
    public ModelAndView bDelete(@RequestParam("bNo")int bNo){
        mav = bsvc.bDelete(bNo);
        return mav;
    }

}
