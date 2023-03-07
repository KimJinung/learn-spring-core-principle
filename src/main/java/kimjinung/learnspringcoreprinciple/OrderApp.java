package kimjinung.learnspringcoreprinciple;

import kimjinung.learnspringcoreprinciple.member.Grade;
import kimjinung.learnspringcoreprinciple.member.Member;
import kimjinung.learnspringcoreprinciple.member.MemberService;
import kimjinung.learnspringcoreprinciple.member.MemberServiceImpl;
import kimjinung.learnspringcoreprinciple.order.Order;
import kimjinung.learnspringcoreprinciple.order.OrderService;
import kimjinung.learnspringcoreprinciple.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "KimJinung", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("Order = " + order);
    }
}
