package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomMovementConditionTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 랜덤으로_움직이는_조건에_충족하면_움직인다(int randomNumber) {
        NumberGenerator numberGenerator = (min, max) -> randomNumber;
        RandomMovementCondition randomMovementCondition = new RandomMovementCondition(numberGenerator);

        boolean result = randomMovementCondition.isMovable();

        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10})
    void 랜덤으로_움직이는_조건에_충족하지_않으면_움직이지_않는다() {
        NumberGenerator numberGenerator = (min, max) -> 3;
        RandomMovementCondition randomMovementCondition = new RandomMovementCondition(numberGenerator);

        boolean result = randomMovementCondition.isMovable();

        assertFalse(result);
    }
}
