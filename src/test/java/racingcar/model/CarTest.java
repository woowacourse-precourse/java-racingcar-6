package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

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

}