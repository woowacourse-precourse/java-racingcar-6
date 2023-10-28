package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class NumberGeneratorTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @RepeatedTest(20)
    void 랜덤넘버_생성시_0이상_9이하_숫자반환() {
        Integer randomNumber = numberGenerator.createRandomNumber();
        assertThat(randomNumber)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }


}