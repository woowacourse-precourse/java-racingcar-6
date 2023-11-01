package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.exception.RacingCarExceptionType.NAME_LENGTH_EXCEEDED;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @DisplayName("유효한 이름으로 RacingCar 객체를 성공적으로 생성한다.")
    @Test
    void createValidCar() {
        // given
        String name = "pobi";

        // when
        RacingCar racingCar = new RacingCar(name);

        // then
        assertThat(racingCar.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("이름 길이 제한을 초과하면 예외를 발생한다.")
    void throwExceptionOnExceedNameLength() {
        // given
        String name = "pobiii";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new RacingCar(name);
        });
        assertThat(exception.getMessage()).isEqualTo(NAME_LENGTH_EXCEEDED.getMessage());
    }
}