package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.ErrorMessage;
import racingcar.dto.input.NumberOfAttemptsDto;
import racingcar.dto.input.RacingCarsDto;
import racingcar.exception.InvalidNumberOfAttemptsException;
import racingcar.exception.InvalidRacingCarsException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    private RacingCarsDto racingCarsDto;
    private NumberOfAttemptsDto numberOfAttemptsDto;

    @Test
    @DisplayName("차 이름이 유효한지 확인한다.")
    void checkInvalidRacingCarName() {
        // given
        String input = "invalidName,pobi";
        // when
        InvalidRacingCarsException exception = assertThrows(InvalidRacingCarsException.class,
                () -> racingCarsDto = new RacingCarsDto(input));
        // then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.INVALID_RACING_CARS);
    }

    @Test
    @DisplayName("시도횟수가 유효한지 확인한다.")
    void checkInvalidNumberOfAttempts() {
        // given
        String input = "0";
        // when
        InvalidNumberOfAttemptsException exception = assertThrows(InvalidNumberOfAttemptsException.class,
                () -> numberOfAttemptsDto = new NumberOfAttemptsDto(input));
        // then
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.INVALID_NUMBER_OF_ATTEMPTS);
    }
}
