package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @Test
    @DisplayName("자동차를 처음 생성하면 자동차 이름을 세팅하고 위치는 0으로 세팅된다.")
    public void 자동차_생성() {
        // given
        Car car = new Car();

        // when
        String carName = "car";
        car.initGame(carName);

        // then
        Assertions.assertThat(carName).isEqualTo(car.getName());
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("자동차가 이동하는데 랜덤한 숫자가 0-3이 나오면 정지한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    public void 자동차_이동_정차(int randomNumber) {
        // given
        Car car = new Car();
        car.initGame("car");

        // when
        car.gameMovement(randomNumber);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("자동차가 이동하는데 랜덤한 숫자가 4-9가 나오면 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 자동차_이동_전진(int randomNumber) {
        // given
        Car car = new Car();
        car.initGame("car");

        // when
        car.gameMovement(randomNumber);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}
