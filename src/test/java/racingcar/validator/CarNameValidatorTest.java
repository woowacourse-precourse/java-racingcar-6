package racingcar.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {

    private final CarNameValidator validator = new CarNameValidator();

    /**
     * positive test
     */
    @Test
    void validateAndGetCarNames_공백_없이_쉼표_구분() {
        String userInput = "pobi,woni,jun";
        List<String> carNames = validator.validateAndGetCarNames(userInput);
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void validateAndGetCarNames_공백_있고_쉼표_구분() {
        String userInput = "pobi     , woni,   jun";
        List<String> carNames = validator.validateAndGetCarNames(userInput);
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void validateAndGetCarNames_한글이름() {
        String userInput = "안녕,나는,세민";
        List<String> carNames = validator.validateAndGetCarNames(userInput);
        assertThat(carNames).containsExactly("안녕", "나는", "세민");
    }

    /**
     * negative test
     */
    @Test
    void validateAndGetCarNames_입력이_없을때_검증() {
        String userInput = "";
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetCarNames(userInput));
    }

    @Test
    void validateAndGetCarNames_입력에_공백만_있을때_검증() {
        String userInput = "      ";
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetCarNames(userInput));
    }

    @Test
    void validateAndGetCarNames_잘못된_구분자_검증() {
        String userInput = "hello/my/name/is/semin";
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetCarNames(userInput));
    }

    @Test
    void validateAndGetCarNames_잘못된_이름_길이_검증() {
        String userInput = "77777777,333,999999999";
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetCarNames(userInput));
    }

    @Test
    void validateAndGetCarNames_중복된_이름_검증() {
        String userInput = "semin,semin,hi";
        assertThrows(IllegalArgumentException.class, () -> validator.validateAndGetCarNames(userInput));
    }

}