package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicMovementRuleTest {

    @DisplayName("숫자가 4 이상이면 true를 반환한다. 4보다 작으면 false를 반환한다.")
    @Test
    void isMovingCondition() {
        BasicMovementRule basicMovementRule = new BasicMovementRule();

        boolean isTrue = basicMovementRule.isMovingCondition(4);
        boolean isFalse = basicMovementRule.isMovingCondition(2);

        Assertions.assertAll(
                () -> Assertions.assertTrue(isTrue),
                () -> Assertions.assertFalse(isFalse)
        );
    }
}
