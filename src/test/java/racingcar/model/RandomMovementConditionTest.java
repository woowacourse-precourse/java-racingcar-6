package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomMovementConditionTest {

    @Test
    void 랜덤으로_움직이는_조건에_충족하면_움직인다() {
        NumberGenerator numberGenerator = (min, max) -> 4;
        RandomMovementCondition randomMovementCondition = new RandomMovementCondition(numberGenerator);

        boolean actual = randomMovementCondition.isMovable();

        assertTrue(actual);
    }

    @Test
    void 랜덤으로_움직이는_조건에_충족하지_않으면_움직이지_않는다() {
        NumberGenerator numberGenerator = (min, max) -> 3;
        RandomMovementCondition randomMovementCondition = new RandomMovementCondition(numberGenerator);

        boolean actual = randomMovementCondition.isMovable();

        assertFalse(actual);
    }
}
