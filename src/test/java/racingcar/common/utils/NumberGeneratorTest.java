package racingcar.common.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import racingcar.common.consts.SystemConst;

class NumberGeneratorTest {

    @Test
    void 숫자_범위가_MAX_DIGIT_SIZE_부터_MIN_DIGIT_SIZE_인지_검사() {
        int n = NumberGenerator.makeRandomNumber();
        assertTrue(n >= SystemConst.MIN_DIGIT_SIZE && n <= SystemConst.MAX_DIGIT_SIZE);
    }
}