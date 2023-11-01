package racingcar.utils;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarException;

class UserInputValidatorTest {

    private final UserInputValidator userInputValidator = new UserInputValidator();

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private static List<String> convertToList(String input) {
        return asList(input.split(","));
    }

    @DisplayName("이름은 5자를 초과하지 않아야 한다.")
    @Test
    void nameDoesNotExceedLimit() {
        //given
        String input = "pobi,javaji";
        List<String> carNames = convertToList(input);

        //then
        assertThatThrownBy(() -> userInputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarException.INVALID_CAR_NAME_LENGTH_MSG);
    }

    @DisplayName("이름은 공백이어서는 안된다.")
    @Test
    void nameShouldNotBeBlank() {
        //given
        String input = "pobi, ,jun";
        List<String> carNames = convertToList(input);

        //then
        assertThatThrownBy(() -> userInputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarException.INVALID_BLANK_NAME_MSG);
    }

    @DisplayName("시도횟수는 숫자이어야 한다.")
    @Test
    void tryCountShouldBeNumeric() {
        //given
        String input = "A";
        systemIn(input);

        //then
        assertThatThrownBy(() -> userInputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarException.INVALID_NUMBER_MSG);
    }

    @DisplayName("시도횟수는 공백이어서는 안 된다.")
    @Test
    void tryCountShouldBeProvided() {
        //given
        String input = " ";
        systemIn(input);

        //then
        assertThatThrownBy(() -> userInputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}