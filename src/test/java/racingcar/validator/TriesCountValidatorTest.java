package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriesCountValidatorTest {

    TriesCountValidator validator = new TriesCountValidator();

    /**
     * positive test
     */
    @Test
    void validateAndGetTriesCount() {
        String userInput = "5";
        int triesCount = validator.validateAndGetTriesCount(userInput);
        org.assertj.core.api.Assertions.assertThat(triesCount).isEqualTo(5);
    }

    /**
     * negative test
     */
    @Test
    void validateAndGetCarNames_입력이_없을때_검증() {
        String userInput = "";
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetTriesCount(userInput));
    }

    @Test
    void validateAndGetCarNames_입력에_공백만_있을때_검증() {
        String userInput = "      ";
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetTriesCount(userInput));
    }

    @Test
    void validateAndGetCarNames_입력이_정수가_아닐때_검증() {
        String userInput = "Hello";
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetTriesCount(userInput));
    }

    @Test
    void validateAndGetCarNames_입력이_음수_검증() {
        String userInput = "-1";
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetTriesCount(userInput));
    }

}