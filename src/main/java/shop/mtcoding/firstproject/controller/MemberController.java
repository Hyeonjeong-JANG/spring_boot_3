package shop.mtcoding.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.firstproject.dto.MemberForm;
import shop.mtcoding.firstproject.entity.Member;
import shop.mtcoding.firstproject.repository.MemberRepository;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String joinForm(){
        return "members/new";
    }

    @PostMapping("/join")
    public String createMember(MemberForm form){
        Member member = form.toEntity();

        Member saved = memberRepository.save(member);
        return "";
    }
}
