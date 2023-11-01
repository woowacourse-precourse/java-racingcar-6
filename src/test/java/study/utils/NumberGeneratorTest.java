package study.utils;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import racingcar.utils.NumberGenerator;

class NumberGeneratorTest {

    @Test
    @RepeatedTest(10)
    void 무작위_숫자_값_생성_음수() {
        int result = NumberGenerator.generateRandNum();
        assertThat(result).isGreaterThan(-1);
    }

    @Test
    @RepeatedTest(10)
    void 무작위_숫자_값_생성_9이상() {
        int result = NumberGenerator.generateRandNum();
        assertThat(result).isLessThan(10);
    }
}