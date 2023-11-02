package racingcar.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidInputException;

public class GameInputValidationTest {

    @DisplayName("양의 정수 입력 검증 - 성공")
    @Test
    void validateIsPositiveIntegerSuccessTest() {
        // given
        String userInput = "5";

        // then
        assertDoesNotThrow(() -> GameInputValidator.validateIsPositiveInteger(userInput));
    }

    @DisplayName("양의 정수 입력 검증 - 실패")
    @Test
    void validateIsPositiveIntegerFailTest() {
        // given
        String input = "-1";

        // then
        assertThrows(InvalidInputException.class,
            () -> GameInputValidator.validateIsPositiveInteger(input));
    }

    @DisplayName("자동차 이름 검증 - 성공")
    @Test
    void validationCarNamesSuccessTest() {
        // given
        String input = "pobi,woni,jun";

        // then
        assertDoesNotThrow(() -> GameInputValidator.validationCarNames(input));
    }

    @DisplayName("자동차 이름 입력시 쉼표(,)가 없는 경우 검증 - 실패")
    @Test
    void checkForCommaFailTest() {
        // given
        String input = "pobi woni jun";

        // then
        assertThrows(InvalidInputException.class,
            () -> GameInputValidator.validationCarNames(input));
    }

    @DisplayName("쉼표 뒤에 공백이 있는 경우 검증 - 실패")
    @Test
    void checkSpacesBetweenCommaAndCarNameFailTest() {
        // given
        String input = "pobi, woni, jun";

        // then
        assertThrows(InvalidInputException.class,
            () -> GameInputValidator.validationCarNames(input));
    }

    @DisplayName("자동차 이름 길이가 5를 초과하는 경우 검증 - 실패")
    @Test
    void checkCarNameLengthFailTest() {
        // given
        String input = "pobinames,woninames,junnames";

        // then
        assertThrows(InvalidInputException.class,
            () -> GameInputValidator.validationCarNames(input));
    }

    @DisplayName("자동차 이름이 비어있는 경우 검증 - 실패")
    @Test
    void checkForEmptyCarNamesFailTest() {
        // given
        String input = ",woni,jun";

        // then
        assertThrows(InvalidInputException.class,
            () -> GameInputValidator.validationCarNames(input));
    }

}

