package com.healthshop.healthshop.controller;

import com.healthshop.healthshop.controller.form.MemberForm;
import com.healthshop.healthshop.domain.member.Member;
import com.healthshop.healthshop.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "member/signup";
    }

//    public String create(@Valid MemberForm form, BindingResult result) {
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
