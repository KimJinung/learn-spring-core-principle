package kimjinung.learnspringcoreprinciple.order;

import kimjinung.learnspringcoreprinciple.member.Grade;
import kimjinung.learnspringcoreprinciple.member.Member;
import kimjinung.learnspringcoreprinciple.member.MemberService;
import kimjinung.learnspringcoreprinciple.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();


    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "KimJinung", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}