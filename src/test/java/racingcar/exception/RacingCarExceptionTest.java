package racingcar.exception;

import org.junit.jupiter.api.Test;

class RacingCarExceptionTest {

    @Test
    void of() {
        //given
        IllegalArgumentException testError = new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME.getMessage());
        //when
        RacingCarException racingCarException = RacingCarException.of(ErrorMessage.DUPLICATED_NAME);
        //then
        org.assertj.core.api.Assertions.assertThat(testError.getMessage()).isEqualTo(racingCarException.getMessage());
    }
}