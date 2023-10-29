package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.ErrorMessage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputRacingCarNameValidatorTest {

    InputRacingCarNameValidator validator = new InputRacingCarNameValidator();


    @DisplayName("RacingCar Name이 공백일 경우 예외 체크")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void validateRacingCarNameLength_WhenNameIsBlank_ThrowsException(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validateRacingCarNameIsBlank(name));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INPUT_DOES_NOT_BLANK.getMessage());
    }

    @DisplayName("RacingCar Name의 길이 예외 체크")
    @ParameterizedTest
    @ValueSource(strings = {"qwer25", "qwerasdfzxcv", "qq23qwe"})
    void validateRacingCarNameLength_WhenNameIsTooLong_ThrowsException(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validateRacingCarNameLength(name));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.RACING_CAR_NAME_TOO_LONG.getMessage());
    }

    @DisplayName("RacingCar Name 정상 길이 체크")
    @ParameterizedTest
    @ValueSource(strings = {"q", "qwer", "qq23"})
    void validateRacingCarNameLength_WhenNameIsNormalLength_DoesNotThrowException(String name) {
        assertDoesNotThrow(() -> validator.validate(name));
    }

}