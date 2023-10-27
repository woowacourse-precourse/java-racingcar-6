package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
    @RepeatedTest(value = 20)
    @DisplayName("0 ~ 9 사이의 숫자가 나오면 성공한다.")
    void RandomNumberGeneratorTest() {
        //given
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        //when,then
        Assertions.assertThat(numberGenerator.generate()).isBetween(0, 9);
    }
}