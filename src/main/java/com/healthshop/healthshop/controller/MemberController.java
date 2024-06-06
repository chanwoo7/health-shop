package com.healthshop.healthshop.controller;

import com.healthshop.healthshop.controller.form.LoginForm;
import com.healthshop.healthshop.controller.form.SignupForm;
import com.healthshop.healthshop.domain.member.Member;
import com.healthshop.healthshop.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("signupForm") @Valid SignupForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/signup";
        }

        Member member = new Member();
        member.setName(form.getName());
        member.setLoginId(form.getLoginId());
        member.setPassword(form.getPassword());
        member.setEmail(form.getEmail());

        memberService.join(member);

        return "redirect:/signup/success";
    }

    @GetMapping("/signup/success")
    public String showSignupSuccessForm() {
        return "member/signupSuccess";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "member/login";
    }

//    public String create(@Valid SignupForm form, BindingResult result) {
//        if (result.hasErrors()) {
//            return "members/createMemberForm";
//        }
//        Member member = new Member();
//
//        member.setName(form.getName());
//        member.setLoginId(form.getLoginId());
//        member.setPassword(form.getPassword());
//        member.setEmail(form.getEmail());
//        member.setPhone(form.getPhone());
//
//        memberService.join(member);
//    }

}
