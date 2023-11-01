package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.GameConstant;
import racingcar.constant.message.NumberOfGamesInputErrorMessage;

public class NumberOfGamesInputValidatorTest {
    @DisplayName("비어있는 시도 횟수 입력에 대한 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 비어있는_시도_횟수_입력시_예외_발생() {
        // given
        final NumberOfGamesInputValidator numberOfGamesInputValidator = new NumberOfGamesInputValidator();

        // when
        final String input = "";

        // then
        assertThatThrownBy(() -> numberOfGamesInputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberOfGamesInputErrorMessage.INPUT_IS_EMPTY);
    }

    @DisplayName("정수 형식이 아닌 시도 횟수 입력에 대한 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 정수_형식이_아닌_시도_횟수_입력시_예외_발생() {
        // given
        final NumberOfGamesInputValidator numberOfGamesInputValidator = new NumberOfGamesInputValidator();

        // when
        final String[] input = {"ab", "cd", "!@#", "12ab", "aa2"};

        // then
        for (String s : input) {
            assertThatThrownBy(() -> numberOfGamesInputValidator.validate(s))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NumberOfGamesInputErrorMessage.INPUT_IS_NOT_NUMERIC_TYPE);
        }
    }

    @DisplayName("최소 시도 횟수인" + GameConstant.NUMBER_OF_GAMES_LOWER_LIMIT
            + "보다 낮게 들어온 시도 횟수 입력에 대한 IllegalArgumentException 발생 여부 테스트")
    @Test
    void 최소_시도_횟수_보다_낮은_시도_횟수_입력시_예외_발생() {
        // given
        final NumberOfGamesInputValidator numberOfGamesInputValidator = new NumberOfGamesInputValidator();

        // when
        final String[] input = {"-1", "-2", "-5", "-1000"};

        // then
        for (String s : input) {
            assertThatThrownBy(() -> numberOfGamesInputValidator.validate(s))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NumberOfGamesInputErrorMessage.INPUT_IS_LOWER_THAN_LIMIT);
        }
    }
}