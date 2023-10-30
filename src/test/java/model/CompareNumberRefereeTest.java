package model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompareNumberRefereeTest {

    private static final int CONDITION_NUMBER = 4;
    private static final int LESS_THAN_CONDITION_NUMBER = CONDITION_NUMBER - 1;

    private CompareNumberReferee compareNumberReferee;

    @BeforeEach
    void init() {
        compareNumberReferee = new CompareNumberReferee();
    }

    @Test
    void 기준_숫자보다_큰_숫자를_뽑았을_때_true를_반환() {
        // when & then
        assertRandomNumberInRangeTest(
            () -> {
                assertTrue(compareNumberReferee.isSatisfiedCondition());
            },
            CONDITION_NUMBER
        );
    }

    @Test
    void 기준_숫자보다_작은_숫자를_뽑았을_때_false를_반환() {
        // when & then
        assertRandomNumberInRangeTest(
            () -> {
                assertFalse(compareNumberReferee.isSatisfiedCondition());
            },
            LESS_THAN_CONDITION_NUMBER
        );
    }
}
