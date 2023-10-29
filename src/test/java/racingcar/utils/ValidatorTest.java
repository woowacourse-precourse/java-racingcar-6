package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ValidatorTest {
    @Test
    void 자동차_이름_입력이_null이면_예외발생() {
        // given
        String carNameInput = null;

        // when, then
        assertThrowsOnInvalidCarName(carNameInput);
    }

    @Test
    void 자동차_이름_입력이_빈_문자열이면_예외발생() {
        // given
        String carNameInput = "";

        // when, then
        assertThrowsOnInvalidCarName(carNameInput);
    }

    @Test
    void 자동차_이름이_빈_문자열이면_예외발생() {
        // given
        String carNameInput = "자동차1,,자동차3";

        // when, then
        assertThrowsOnInvalidCarName(carNameInput);
    }

    @Test
    void 자동차_이름이_5글자보다_길면_예외발생() {
        // given
        String carNameInput = "자동차1,자동차2,자동차12345";

        // when, then
        assertThrowsOnInvalidCarName(carNameInput);
    }

    @Test
    void 자동차_이름_정상입력_테스트() {
        // given
        List<String> validInputs = Arrays.asList(new String[] {
                "자동차1,자동차2,자동차3",
                "!,?"
        });

        // when, then
        validInputs.forEach(
                ValidatorTest::assertNotThrowsOnValidCarName
        );
    }

    private static void assertNotThrowsOnValidCarName(String carName) {
        Assertions.assertDoesNotThrow(() -> {
            Validator.validateCarNames(carName);
        });
    }

    private static void assertThrowsOnInvalidCarName(String carName) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames(carName);
        });
    }
}
