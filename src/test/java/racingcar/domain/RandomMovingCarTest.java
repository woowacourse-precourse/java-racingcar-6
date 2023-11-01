package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomMovingCarTest {

    @DisplayName("차량_생성_성공_테스트")
    @Test
    void creatingCarSuccessTest() {
        String carName = "붕붕카";

        assertThatCode(() -> new RandomMovingCar(carName)).doesNotThrowAnyException();
    }

    @DisplayName("빈_차량_이름_실패_테스트")
    @Test
    void emptyCarNameFailTest() {
        String emptyCarName = "";

        assertThatThrownBy(() -> new RandomMovingCar(emptyCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차량_이름_최대길이_실패_테스트")
    @Test
    void exceededCarNameLengthFailTest() {
        String exceededCarName = "길이초과차명";

        assertThatThrownBy(() -> new RandomMovingCar(exceededCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차량_이동_성공_메소드_테스트")
    @Test
    void movingCarSuccessTest() {
        Car gameCar = new RandomMovingCar("붕붕카");
        int distance = gameCar.getDistance();

        gameCar.attemptToMove();

        assertThat(gameCar.getDistance()).isEqualTo(distance + 1);
    }

    @DisplayName("차량_이동_실패_메소드_테스트")
    @Test
    void movingCarFailTest() {
        Car gameCar = new RandomMovingCar("붕붕카");
        int distance = gameCar.getDistance();

        gameCar.attemptToMove();

        assertThat(gameCar.getDistance()).isEqualTo(distance);
    }
}