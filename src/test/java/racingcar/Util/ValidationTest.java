package racingcar.Util;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ValidationTest {
    @Test
    void 빈_입력_검증() {
        // given
        String unverified = "";
        // when // then
        assertThrows(IllegalArgumentException.class,
                () -> Validation.validationEmpty(unverified));

        // given
        String verified = "test";
        // when // then
        assertEquals(verified, Validation.validationEmpty(verified));
    }

    @Test
    void 시도횟수_입력_검증() {
        // given
        String unverified = "3번";
        // when // then
        assertThrows(IllegalArgumentException.class,
                () -> Validation.validationAttempts(unverified));

        // given
        String verified = "3";
        // when // then
        assertEquals(3, Validation.validationAttempts(verified));
    }

    @Test
    void 자동차_이름_길이_검증() {
        // given
        String unverified = "banana";
        // when // then
        assertThrows(IllegalArgumentException.class,
                () -> Validation.validationCarName(unverified));

        // given
        String verified = "test";
        // when // then
        assertEquals(verified, Validation.validationCarName(verified));
    }
}