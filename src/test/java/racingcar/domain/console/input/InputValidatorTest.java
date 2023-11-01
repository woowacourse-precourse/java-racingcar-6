package racingcar.domain.console.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    private final InputValidator inputValidator = InputValidator.newInstance();

    @Test
    void 이름_길이_초과_익셉션_테스트() {
        // given
        final String name = "pobigo";

        // when
        // then
        assertThatThrownBy(() ->
                inputValidator.validateNameLength(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_길이_성공_테스트() {
        // given
        final String name = "pobig";

        // when
        // then
        assertThatCode(() -> inputValidator.validateNameLength(name))
                .doesNotThrowAnyException();
    }


    @Test
    void 최소_라운드_미만_익셉션_테스트() {
        // given
        final int FAIL_COUNT = 0;

        // when
        // then
        assertThatThrownBy(() ->
                inputValidator.validateAttemptSize(FAIL_COUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최소_라운드_성공_테스트() {
        // given
        final int SUCCESS_COUNT = 1;

        // when
        // then
        assertThatCode(() -> inputValidator.validateAttemptSize(SUCCESS_COUNT))
                .doesNotThrowAnyException();
    }


    @Test
    void 숫자가_아닌_경우_익셉션_테스트() {
        // given
        final String INPUT_NOT_NUMBER = "r";

        // when
        // then
        assertThatThrownBy(() ->
                inputValidator.validateNumericInput(INPUT_NOT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자인_경우_성공_테스트() {
        // given
        final String INPUT_NUMBER = "1";

        // when
        // then
        assertThatCode(() -> inputValidator.validateNumericInput(INPUT_NUMBER))
                .doesNotThrowAnyException();
    }

}