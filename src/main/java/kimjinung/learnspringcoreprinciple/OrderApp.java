package kimjinung.learnspringcoreprinciple;

import kimjinung.learnspringcoreprinciple.member.Grade;
import kimjinung.learnspringcoreprinciple.member.Member;
import kimjinung.learnspringcoreprinciple.member.MemberService;
import kimjinung.learnspringcoreprinciple.member.MemberServiceImpl;
import kimjinung.learnspringcoreprinciple.order.Order;
import kimjinung.learnspringcoreprinciple.order.OrderService;
import kimjinung.learnspringcoreprinciple.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "KimJinung", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("Order = " + order);
    }
}
