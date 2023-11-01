package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.round.InvalidMaxRoundInputException;
import racingcar.view.validator.InputValidator;

final class InputValidatorTest {

    @DisplayName(",로 이름이 구분된 문자열 검증 성공")
    @Test
    void validateCarNamesInput_withStringSeparatedCommas_shouldBeOk() {
        // given
        final String input1 = "a";
        final String input2 = "pobi,pss";
        final InputValidator inputValidator = new InputValidator();
        // when
        // then
        inputValidator.validateCarNamesInput(input1);
        inputValidator.validateCarNamesInput(input2);
    }

    @DisplayName("1자리 숫자로 이루어진 MaxRound 입력 시, 검증 성공")
    @Test
    void validateMaxRoundInput_singleNumberString_shouldBeOk() {
        // given
        final String input1 = "1";
        final String input2 = "2";
        final String input3 = "9";
        final InputValidator inputValidator = new InputValidator();
        // when
        // then
        inputValidator.validateMaxRoundInput(input1);
        inputValidator.validateMaxRoundInput(input2);
        inputValidator.validateMaxRoundInput(input3);
    }

    @DisplayName("1자리 외의 숫자 혹은 공백 및 숫자 이외의 MaxRound 입력 예외 발생")
    @Test
    void validateMaxRoundInput_exceptSingleNumberString_throwInvalidMaxRoundInputException() {
        // given
        final String input1 = "";
        final String input2 = "12x";
        final String input3 = "X";
        final InputValidator inputValidator = new InputValidator();
        // when
        // then
        assertThatThrownBy(() ->
                inputValidator.validateMaxRoundInput(input1))
                .isInstanceOf(InvalidMaxRoundInputException.class)
                .hasMessage(InvalidMaxRoundInputException.INVALID_MAX_ROUND_INPUT_EXCEPTION_MESSAGE);

        assertThatThrownBy(() ->
                inputValidator.validateMaxRoundInput(input2))
                .isInstanceOf(InvalidMaxRoundInputException.class)
                .hasMessage(InvalidMaxRoundInputException.INVALID_MAX_ROUND_INPUT_EXCEPTION_MESSAGE);

        assertThatThrownBy(() ->
                inputValidator.validateMaxRoundInput(input3))
                .isInstanceOf(InvalidMaxRoundInputException.class)
                .hasMessage(InvalidMaxRoundInputException.INVALID_MAX_ROUND_INPUT_EXCEPTION_MESSAGE);
    }

    @DisplayName(",로 이름이 구분되었으나 공백이 포함되거나 빈 문자열은 검증 실패")
    @Test
    void validateMaxRoundInput_includesWhiteSpaces_throwInvalidMaxRoundInputException() {
        // given
        final String input1 = "a,b, ";
        final String input2 = "a,\t,c";
        final String input3 = "a,\n,c";
        final InputValidator inputValidator = new InputValidator();
        // when
        // then
        assertThatThrownBy(() ->
                inputValidator.validateMaxRoundInput(input1))
                .isInstanceOf(InvalidMaxRoundInputException.class)
                .hasMessage(InvalidMaxRoundInputException.INVALID_MAX_ROUND_INPUT_EXCEPTION_MESSAGE);

        assertThatThrownBy(() ->
                inputValidator.validateMaxRoundInput(input2))
                .isInstanceOf(InvalidMaxRoundInputException.class)
                .hasMessage(InvalidMaxRoundInputException.INVALID_MAX_ROUND_INPUT_EXCEPTION_MESSAGE);

        assertThatThrownBy(() ->
                inputValidator.validateMaxRoundInput(input3))
                .isInstanceOf(InvalidMaxRoundInputException.class)
                .hasMessage(InvalidMaxRoundInputException.INVALID_MAX_ROUND_INPUT_EXCEPTION_MESSAGE);
    }
}