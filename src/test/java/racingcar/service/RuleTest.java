package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RuleTest {

    @DisplayName("숫자가 4 이상이면 true를 반환한다. 4보다 작으면 false를 반환한다.")
    @Test
    void isMovingCondition() {
        Rule rule = new Rule();

        boolean isTrue = rule.isMovingCondition(4);
        boolean isFalse = rule.isMovingCondition(2);

        Assertions.assertAll(
                () -> Assertions.assertTrue(isTrue),
                () -> Assertions.assertFalse(isFalse)
        );
    }
}
