package kimjinung.learnspringcoreprinciple;

import kimjinung.learnspringcoreprinciple.member.Grade;
import kimjinung.learnspringcoreprinciple.member.Member;
import kimjinung.learnspringcoreprinciple.member.MemberService;
import kimjinung.learnspringcoreprinciple.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "KimJinung", Grade.VIP);
        memberService.join(member);
        memberService.findMember(1L);
    }
}
