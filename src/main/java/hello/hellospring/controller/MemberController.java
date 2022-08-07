package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    /* dependency injection */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
