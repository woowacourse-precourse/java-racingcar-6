package racingcar.playrule;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomNumberRacingRuleTest {

    RandomNumberRacingRule randomNumberRacingRule;

    @BeforeEach
    void init() {
        randomNumberRacingRule = new RandomNumberRacingRule();
    }

    @Test
    void random_랜덤_생성_숫자_4_이상일시_true() {
        assertTrue(randomNumberRacingRule.isMovable(4));
        assertTrue(randomNumberRacingRule.isMovable(5));
        assertTrue(randomNumberRacingRule.isMovable(6));
        assertTrue(randomNumberRacingRule.isMovable(7));
        assertTrue(randomNumberRacingRule.isMovable(8));
        assertTrue(randomNumberRacingRule.isMovable(9));
    }

    @Test
    void random_랜덤_생성_숫자_4_미만일시_false() {
        assertFalse(randomNumberRacingRule.isMovable(1));
        assertFalse(randomNumberRacingRule.isMovable(2));
        assertFalse(randomNumberRacingRule.isMovable(3));
    }

}