package kimjinung.learnspringcoreprinciple.discount;

import kimjinung.learnspringcoreprinciple.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
