package kimjinung.learnspringcoreprinciple;

import kimjinung.learnspringcoreprinciple.discount.RateDiscountPolicy;
import kimjinung.learnspringcoreprinciple.member.MemberService;
import kimjinung.learnspringcoreprinciple.member.MemberServiceImpl;
import kimjinung.learnspringcoreprinciple.member.MemoryMemberRepository;
import kimjinung.learnspringcoreprinciple.order.OrderService;
import kimjinung.learnspringcoreprinciple.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //Service layer
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    // Repository layer
    @Bean
    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    private static RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
