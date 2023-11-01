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
        List<String> validInputs = Arrays.asList(
                "자동차1,자동차2,자동차3",
                "!,?"
        );

        // when, then
        validInputs.forEach(ValidatorTest::assertNotThrowsOnValidCarName);
    }

    private static void assertNotThrowsOnValidCarName(String carName) {
        Assertions.assertDoesNotThrow(() ->
                Validator.validateCarNames(carName)
        );
    }

    private static void assertThrowsOnInvalidCarName(String carName) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            Validator.validateCarNames(carName)
        );
    }

    @Test
    void 실행횟수_입력이_null이면_예외발생() {
        // given
        String roundNumber = null;

        // when, then
        assertThrowsOnInvalidRoundNumber(roundNumber);
    }

    @Test
    void 실행횟수_입력이_음수면_예외발생() {
        // given
        String roundNumber = "-5";

        // when, then
        assertThrowsOnInvalidRoundNumber(roundNumber);
    }

    @Test
    void 실행횟수_입력이_빈_문자열이면_예외발생() {
        // given
        String roundNumber = "";

        // when, then
        assertThrowsOnInvalidRoundNumber(roundNumber);
    }

    @Test
    void 실행횟수_입력이_int_범위를_넘어가면_예외발생() {
        // given
        String roundNumber = "9999999999";

        // when, then
        assertThrowsOnInvalidRoundNumber(roundNumber);
    }

    @Test
    void 실행횟수_정상입력_테스트() {
        // given
        List<String> validInputs = Arrays.asList(
                "1",
                "20"
        );

        // when, then
        validInputs.forEach(ValidatorTest::assertNotThrowsOnValidRoundNumber);
    }

    private static void assertNotThrowsOnValidRoundNumber(String roundNumber) {
        Assertions.assertDoesNotThrow(() ->
                Validator.validateRoundNumber(roundNumber)
        );
    }

    private void assertThrowsOnInvalidRoundNumber(String roundNumber) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                Validator.validateRoundNumber(roundNumber)
        );
    }
}
