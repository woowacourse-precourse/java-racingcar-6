package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.result.RacingCarResult;

class RacingCarTest {

    @DisplayName("자동차 이름이 1 ~ 5자가 아니면 예외가 발생한다.")
    @Test
    void insertInvalidLengthName() {
        String invalidName = "longName";

        Assertions.assertThatThrownBy(() -> new RacingCar(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 4이상이면 차량이 이동된다.")
    @Test
    void move() {
        RacingCar racingCar = new RacingCar("test");
        Integer moveCommand = 4;
        Integer currentLocation = getCurrentLocation(racingCar);

        racingCar.move(moveCommand);
        RacingCarResult result = racingCar.toResult();

        Assertions.assertThat(result.location()).isEqualTo(currentLocation + 1);
    }

    private Integer getCurrentLocation(RacingCar racingCar) {
        RacingCarResult result = racingCar.toResult();
        return result.location();
    }
}
