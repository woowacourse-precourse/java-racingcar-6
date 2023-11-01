package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarExceptionTest {

    @Test
    void 이름_길이_예외_테스트() {
        // given
        final String EXCEPTION_MESSAGE = "[Error] 이름은 5자 이하만 가능합니다.";

        // when
        // then
        Assertions.assertThatThrownBy(RacingCarException.NAME_LENGTH_EXCEPTION::getException)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_MESSAGE);
    }

    @Test
    void 시도_최소_횟수_예외_테스트() {
        // given
        final String EXCEPTION_MESSAGE = "[Error] 시도할 횟수는 최소 1회 이상입니다.";

        // when
        // then
        Assertions.assertThatThrownBy(RacingCarException.ATTEMPT_MINIMUM_COUNT_EXCEPTION::getException)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_MESSAGE);
    }

    @Test
    void 숫자_입력_예외_테스트() {
        // given
        final String EXCEPTION_MESSAGE = "[Error] 숫자만 입력해주세요.";

        // when
        // then
        Assertions.assertThatThrownBy(RacingCarException.NUMERIC_INPUT_EXCEPTION::getException)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_MESSAGE);
    }


}