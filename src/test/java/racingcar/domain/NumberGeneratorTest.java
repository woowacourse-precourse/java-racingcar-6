package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    @Test
    void 랜덤_숫자_생성_0에서_9사이() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int result = numberGenerator.createRandomNumber();
        assertThat(result).isBetween(0, 9);
    }
}
