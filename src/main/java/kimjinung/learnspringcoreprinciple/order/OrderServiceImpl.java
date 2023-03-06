package kimjinung.learnspringcoreprinciple.order;

import kimjinung.learnspringcoreprinciple.discount.DiscountPolicy;
import kimjinung.learnspringcoreprinciple.discount.FixDiscountPolicy;
import kimjinung.learnspringcoreprinciple.member.Member;
import kimjinung.learnspringcoreprinciple.member.MemberRepository;
import kimjinung.learnspringcoreprinciple.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
