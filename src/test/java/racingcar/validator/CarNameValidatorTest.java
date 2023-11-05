package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.config.GameConfig.NAME_LENGTH_CONDITION;
import static racingcar.exception.ErrorMessage.*;

@DisplayName("CarNameValidatorTest")
class CarNameValidatorTest {

    @Test
    @DisplayName("입력된 문자열이 비어있다면 예외를 반환한다.")
    void validateEmptyForInputString() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> CarNameValidator.validateForInputString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALIDATE_EMPTY_FOR_INPUT_STRING.getMessage());
    }

    @Test
    @DisplayName("입력된 문자열이 쉼표(,)를 포함하고 있지 않다면 예외를 반환한다.")
    void validateContainsCommaForInputString() {
        // given
        String input = "holy Pigeon";

        // when, then
        assertThatThrownBy(() -> CarNameValidator.validateForInputString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALIDATE_CONTAINS_COMMA_FOR_INPUT_STRING.getMessage());
    }

    @Test
    @DisplayName("리스트가 중복된 원소를 가지고 있다면 예외를 반환한다.")
    void validateDuplicateForList() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("name1");
        carNames.add("name1");
        carNames.add("name3");

        // when, then
        assertThatThrownBy(() -> CarNameValidator.validateDuplicateForList(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALIDATE_DUPLICATE_FOR_LIST.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열일 경우 예외를 반환한다.")
    void validateEmpty() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> CarNameValidator.validateForEachName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALIDATE_EMPTY_FOR_EACH_NAME.getMessage());
    }

    @Test
    @DisplayName("이름의 길이가 기준값 초과일 경우 예외를 반환한다.")
    void validateLength() {
        // given
        String input = "holyPigeon";

        // when, then
        assertThatThrownBy(() -> CarNameValidator.validateForEachName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(VALIDATE_LENGTH_FOR_EACH_NAME.getMessage(), NAME_LENGTH_CONDITION.getNumber()));
    }
}