package kimjinung.learnspringcoreprinciple.discount;

import kimjinung.learnspringcoreprinciple.member.Grade;
import kimjinung.learnspringcoreprinciple.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountPercent * price / 100;
        }

        return 0;
    }
}
