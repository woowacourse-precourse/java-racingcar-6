package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StepCountTest {

    private StepCount stepCount;

    @BeforeEach
    void init() {
        stepCount = new StepCount(1);
    }

    @Test
    void 양의정수가_아닌_stepCount생성은_IllegalArgumentException을_발생시킨다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new StepCount(0));
    }

    @Test
    void validateStepCount는_양의정수입력시_true를반환한다() {
        Assertions.assertTrue(stepCount.validateStepCount(1));
    }

    @Test
    void validateStepCount는_0이하_정수입력시_false를반환한다() {
        Assertions.assertFalse(stepCount.validateStepCount(0));
        Assertions.assertFalse(stepCount.validateStepCount(-1));
    }

    @Test
    void isStepCountZero는_stepCount가_0이면_true를_반환한다() {
        stepCount.decreaseStep();
        Assertions.assertTrue(stepCount.isStepCountZero());
    }

}
