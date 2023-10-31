package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final String CORRECT_NAME = "pobi";
    private static final int MOVABLE_NUMBER = 4;
    private static final int IMMOVABLE_NUMBER = 3;

    @Test
    @DisplayName("자동차 객체 생성 성공")
    void carTest() {
        // given
        String name = CORRECT_NAME;

        // when
        Car car = new Car(name);

        // then
        Assertions.assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("4 이상이면 전진")
    void goOrStopTestGo() {
        // given
        Car car = new Car(CORRECT_NAME);

        // when
        car.goOrStop(MOVABLE_NUMBER);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4 미만이면 정지")
    void goOrStopTestStop() {
        // given
        Car car = new Car(CORRECT_NAME);

        // when
        car.goOrStop(IMMOVABLE_NUMBER);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
