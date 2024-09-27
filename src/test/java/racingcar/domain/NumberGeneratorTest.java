package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;


class NumberGeneratorTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @RepeatedTest(100)
    void create_랜덤한_숫자를_생성합니다() {
        int result = numberGenerator.createRandomNumber();

        assertTrue(result >= 0 && result <= 9);
    }

}