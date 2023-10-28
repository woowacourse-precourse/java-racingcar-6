package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JudgeTest {

    private Judge judge;

    @BeforeEach
    void setup() {
        judge = new Judge();
    }

    @Test
    void 랜덤_숫자에_따른_전진_판단() {
        int CanRushNumber = 4;
        Assertions.assertTrue(judge.canRush(CanRushNumber));
    }

    @Test
    void 랜덤_숫자에_따른_정지_판단() {
        int CanRushNumber = 3;
        Assertions.assertFalse(judge.canRush(CanRushNumber));
    }
}
