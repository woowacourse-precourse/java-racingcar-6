package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.round.Round;
import racingcar.error.ErrorMessage;
import racingcar.error.RacingCarDrivers.NameInputNullException;
import racingcar.error.RacingCarDrivers.NameLengthExceededException;
import racingcar.error.Roud.InvalidNumberFormatException;

class RacingCarDriversTest {

    String racingCarDriversName = "ha, kim, zin";
    String sizeOverName = "testName";
    String nullInput = "";

    @Test
    @DisplayName("RacingCarDrivers 배열 출력 TEST")
    void getRacingCarDriversArray() {
        RacingCarDrivers racingCarDrivers = new RacingCarDrivers(racingCarDriversName);
        assertThat(racingCarDrivers.getRacingCarDriversArray().length).isEqualTo(3);
    }

    @Test
    @DisplayName("공백이 입련된 에러 TEST")
    void validateDriverNameCaseInputNull() {
        assertThatThrownBy(() -> new RacingCarDrivers(nullInput))
            .isInstanceOf(NameInputNullException.class)
            .hasMessage(ErrorMessage.NAME_INPUT_NULL_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("입력 이름이 5자리 이상 입력된 에러 TEST")
    void validateDriverNameCaseOverNameSize() {
        assertThatThrownBy(() -> new RacingCarDrivers(sizeOverName))
            .isInstanceOf(NameLengthExceededException.class)
            .hasMessage(ErrorMessage.NAME_LENGTH_EXCEEDED_EXCEPTION.getMessage());
    }
}