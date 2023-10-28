package racingcar.parser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidMaxRoundInputException;
import racingcar.validator.InputValidator;
import round.boxed.MaxRound;

final class InputParserTest {
    @DisplayName("양수를 입력하면 maxRound 변환 성공")
    @Test
    void parseMaxRoundSuccess() {
        // given
        final String input1 = "1";
        final InputValidator inputValidator = new InputValidator();
        final InputParser inputParser = new InputParser(inputValidator);

        // when
        final MaxRound maxRound1 = inputParser.parseToMaxRound(input1);

        // then
        assertThat(maxRound1)
                .extracting("round")
                .isEqualTo(1);
    }

    @DisplayName("음수를 입력하면 maxRound 변환 시 예외 발생")
    @Test
    void parseMaxRoundFailureWithNegative() {
        // given
        final String input1 = "-1";
        final InputValidator inputValidator = new InputValidator();
        final InputParser inputParser = new InputParser(inputValidator);

        // when
        // then
        assertThatThrownBy(
                () -> inputParser.parseToMaxRound(input1)
        )
                .isInstanceOf(InvalidMaxRoundInputException.class)
                .hasMessage(InvalidMaxRoundInputException.INVALID_MAX_ROUND_INPUT_EXCEPTION_MESSAGE);
    }

    @DisplayName("수 외의 문자를 입력하면 maxRound 변환 시 예외 발생")
    @Test
    void parseMaxRoundFailureWithoutNumberString() {
        // given
        final String input1 = "x";
        final InputValidator inputValidator = new InputValidator();
        final InputParser inputParser = new InputParser(inputValidator);

        // when
        // then
        assertThatThrownBy(
                () -> inputParser.parseToMaxRound(input1)
        )
                .isInstanceOf(InvalidMaxRoundInputException.class)
                .hasMessage(InvalidMaxRoundInputException.INVALID_MAX_ROUND_INPUT_EXCEPTION_MESSAGE);
    }
}