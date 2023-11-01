package racingcar;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    @Test
    @RepeatedTest(100)
    void 무작위_숫자_값_생성_음수() {
        int result = NumberGenerator.createRandomNumber();
        assertThat(result).isGreaterThan(-1);
    }

    @Test
    @RepeatedTest(100)
    void 무작위_숫자_값_생성_9이상() {
        int result = NumberGenerator.createRandomNumber();

        assertThat(result).isLessThan(10);
    }
}
