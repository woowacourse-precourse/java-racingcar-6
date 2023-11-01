package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 정상 생성 테스트")
    void createCarTest() {
        String name = "kim";
        assertThat(new Car(name).getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 생성 예외 테스트")
    void createCarExceptionTest() {
        String longName = "honggildong";
        assertThatThrownBy(() -> new Car(longName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 한칸 전진 테스트")
    void moveForwardTest() {
        Car carA = new Car("carA");
        int firstMove = 1;

        carA.moveForward(4);

        assertThat(carA.getPosition()).isEqualTo(firstMove);
    }

    @Test
    @DisplayName("자동차 전진 실패 테스트")
    void noMoveForwardTest() {
        Car carA = new Car("carA");
        int noMove = 0;

        carA.moveForward(0);

        assertThat(carA.getPosition()).isEqualTo(noMove);
    }

    @Test
    @DisplayName("자동차 상태 출력 테스트")
    void carNoForwardStatusTest() {
        Car carA = new Car("carA");

        carA.moveForward(0);

        String expectStatus = "carA : ";

        assertThat(carA.getCarStatus()).isEqualTo(expectStatus);
    }

    @Test
    @DisplayName("자동차 전진 후 상태 출력 테스트")
    void carForwardStatusTest() {
        Car carA = new Car("carA");

        carA.moveForward(5);

        String expectStatus = "carA : -";

        assertThat(carA.getCarStatus()).isEqualTo(expectStatus);
    }

}