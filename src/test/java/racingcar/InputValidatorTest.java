package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.Constant.SPLIT_REGEX;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;
import racingcar.validator.InputValidator;

public class InputValidatorTest {
    @Test
    @DisplayName("자동차 이름 입력 테스트 - 조건에 맞는 입력 값이 입력된 케이스")
    void 조건에_맞는_이름이_입력된_경우() {
        final String input = "가,나,다,라";

        assertThatCode(() -> {
            InputValidator.validateCarNameInput(List.of(input.split(SPLIT_REGEX)));
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - 중복된 이름이 입력된 케이스")
    void 중복된_이름이_입력된_경우() {
        final String input = "가,나,가,다,라,마";

        assertThatThrownBy(() -> {
            InputValidator.validateCarNameInput(List.of(input.split(SPLIT_REGEX)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - 공백이 포함된 이름이 입력된 케이스")
    void 공백이_포함된_이름이_입력된_경우() {
        final String input = "가 나,다,라";

        assertThatThrownBy(() -> {
            InputValidator.validateCarNameInput(List.of(input.split(SPLIT_REGEX)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_INCLUDE_BLANK_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 - 5자 이상인 이름이 입력된 케이스")
    void 길이가_5자_이상인_이름이_입력된_경우() {
        final String input = "가나다라마바,사,아,자";

        assertThatThrownBy(() -> {
            InputValidator.validateCarNameInput(List.of(input.split(SPLIT_REGEX)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_OVER_LENGTH_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("게임 횟수 입력 테스트 - 조건에 맞는 입력 값이 입력된 케이스")
    void 조건에_맞는_입력_값이_입력된_경우() {
        final String input = "5";

        assertThatCode(() -> {
            InputValidator.validateGameSetInput(input);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("게임 횟수 입력 테스트 - 숫자가 아닌 값이 입력된 케이스")
    void 숫자가_아닌_값이_입력된_경우() {
        final String input = "a";

        assertThatThrownBy(() -> {
            InputValidator.validateGameSetInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.SET_NOT_NUMBER_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("게임 횟수 입력 테스트 - 1이상 99이하가 아닌 숫자가 입력된 케이스")
    void 입력_가능_범위가_아닌_값이_입력된_경우() {
        final String input = "100";

        assertThatThrownBy(() -> {
            InputValidator.validateGameSetInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.SET_RANGE_EXCEPTION_MESSAGE);
    }
}
