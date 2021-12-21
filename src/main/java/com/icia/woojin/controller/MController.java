package com.icia.woojin.controller;

import com.icia.woojin.dto.MEMBER;
import com.icia.woojin.service.MService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@Controller
public class MController {
    @Autowired
    private MService msvc;

    @Autowired
    private HttpSession session;

    @Autowired
    private JavaMailSender mailsender;

    private ModelAndView mav = new ModelAndView();





    // joinForm : 회원가입 페이지로 이동
    @RequestMapping(value="joinForm", method = RequestMethod.GET)
    public String joinForm(){
        return "joinForm";
    }

    // A_idoverlap : 아이디 중복 검사
    @RequestMapping(value="/idOverlap", method = RequestMethod.POST)
    public @ResponseBody
    String idOverlap(@RequestParam("mId") String mId) {
        System.out.println("=================idOverlap==============");
        System.out.println("[1]controller : mId -> " + mId);
        String result  = msvc.idOverlap(mId);
        System.out.println("[5]controller : result -> " + result);

        return result;
    }

    // loginForm : 로그인 페이지로 이동
    @RequestMapping(value="loginForm", method = RequestMethod.GET)
    public String loginForm(){
        return "loginForm";
    }




    // mJoin : 회원가입
    @RequestMapping(value="mJoin", method = RequestMethod.POST)
    public ModelAndView mJoin(@ModelAttribute MEMBER member) throws IOException {
        System.out.println(" ========= mJoin 메소드 ========= ");
        System.out.println("[1]controller : member -> " + member);

        mav = msvc.mJoin(member);
        System.out.println("[4]controller : mav -> " + mav);

        return mav;
    }

    // mLogin : 로그인
    @RequestMapping(value="mLogin", method = RequestMethod.POST)
    public ModelAndView mLogin(@ModelAttribute MEMBER member){
        System.out.println(" ========= mLogin 메소드 ========= ");
        System.out.println("[1]controller : member -> " + member);

        mav = msvc.mLogin(member);
        System.out.println("[4]controller : mav -> " + mav);

        return mav;
    }

    // logout : 로그아웃
    @RequestMapping(value="mLogout", method = RequestMethod.GET)
    public String mLogout(){
        System.out.println(" 여기로 안넘어오는거 같은데요= ");
        System.out.println(" ========= logout 메소드 ========= ");
        session.invalidate();   // session을 초기화 하는 작업
        return "index";
    }

    // mList : 회원목록 보기
    @RequestMapping(value="mList", method = RequestMethod.GET)
    public ModelAndView mList(){
        System.out.println(" ========= mList 메소드 ========= ");
        System.out.println("[1]controller");

        mav = msvc.mList();
        System.out.println("[4]controller : mav -> " + mav);

        return mav;
    }

    // mView : 회원 상세보기
    @RequestMapping(value="mView", method = RequestMethod.GET)
    public ModelAndView mView(@RequestParam("mId") String mId){
        mav = msvc.mView(mId);
        return mav;
    }

    // mModiForm : 회원 수정 페이지로 이동
    @RequestMapping(value="mModiForm", method = RequestMethod.GET)
    public ModelAndView mModiForm(@RequestParam("mId") String mId){
        mav = msvc.mModiForm(mId);
        return mav;
    }

    // mModify : 회원 수정
    @RequestMapping(value="mModify", method = RequestMethod.POST)
    public ModelAndView mModify(@ModelAttribute MEMBER member) throws IOException {
        System.out.println(" ========= mModify 메소드 ========= ");
        System.out.println("[1]controller : member -> " + member);

        mav = msvc.mModify(member);
        System.out.println("[4]controller : mav -> " + mav);

        return mav;
    }

    // mDelete : 회원 삭제(GET방식)
    @RequestMapping(value="mDelete", method = RequestMethod.GET)
    public ModelAndView mDelete(@RequestParam("mId") String mId){
        mav = msvc.mDelete(mId);
        return mav;
    }
    // aa
    @RequestMapping(value="aa", method = RequestMethod.GET)
    public ModelAndView aa(@RequestParam("bb") String bb){
        System.out.println("bb : " + bb);
        return mav;
    }

    // A_emailConfirm : 이메일 인증번호 발송
    @RequestMapping(value="/A_emailConfirm", method = RequestMethod.GET)
    public @ResponseBody String emailConfirm(@RequestParam("mEmail") String MEmail) {

        String uuid = UUID.randomUUID().toString().substring(1,7);


        JavaMailSender mailSender;
        MimeMessage mail = mailsender.createMimeMessage();

        String message ="<h2>안녕하세요. 인천일보 아카데미 입니다</h2>"
                + "<br/>인증번호는 " + uuid + " 입니다.</p>"
                + "<p>인증번호를 인증번호 입력란에 입력해주세요</p>"
                + "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다.)";

        try {
            mail.setSubject("[본인인증] 인천일보 아카데미 인증메일입니다.", "utf-8");
            mail.setText(message, "utf-8", "html");
            mail.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(MEmail));
            mailsender.send(mail);

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        return uuid;
    }



    // @RequestMapping(value="/index", method = RequestMethod.GET)
    // @GetMapping("index")

    // @RequestMapping(value="/join", method = RequestMethod.POST)
    // @PostMapping("index")

    //


}
