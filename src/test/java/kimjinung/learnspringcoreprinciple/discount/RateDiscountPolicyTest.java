package kimjinung.learnspringcoreprinciple.discount;

import kimjinung.learnspringcoreprinciple.AppConfig;
import kimjinung.learnspringcoreprinciple.member.Grade;
import kimjinung.learnspringcoreprinciple.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy;
    @BeforeEach
    public void beforeEach() {
        discountPolicy = new RateDiscountPolicy();
    }
    @Test
    @DisplayName("VIP must get a 10% discount")
    void whenMemberIsVIP() {
        Member member = new Member(1L, "KimJinng", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Basic member can't get discount")
    void whenMemberIsNotVIP() {
        Member member = new Member(1L, "KimJinung", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }
}