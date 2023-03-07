package kimjinung.learnspringcoreprinciple.order;

import kimjinung.learnspringcoreprinciple.discount.DiscountPolicy;
import kimjinung.learnspringcoreprinciple.discount.FixDiscountPolicy;
import kimjinung.learnspringcoreprinciple.member.Member;
import kimjinung.learnspringcoreprinciple.member.MemberRepository;
import kimjinung.learnspringcoreprinciple.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
