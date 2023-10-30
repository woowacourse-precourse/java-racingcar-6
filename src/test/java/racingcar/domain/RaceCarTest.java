package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceCarTest {
    private final int MOVE = 4;
    private final int STOP = 0;
    private RaceCar raceCar;

    @BeforeEach
    void setUp() {
        raceCar = new RaceCar("Test");
    }

    private void moveRaceCar(RaceCar raceCar) {
        raceCar.movementControlCar(MOVE);
    }

    @DisplayName("자동차의 이동을 제어한다.")
    @Test
    void movementControlCar() {
        // when
        raceCar.movementControlCar(MOVE);

        int resultNum = raceCar.getCntMovementOfCar();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(1);
        assertThat(rasultStr).isEqualTo("-");
    }

    @DisplayName("자동차의 이동을 제어한다._2")
    @Test
    void movementControlCar_2() {
        // when
        raceCar.movementControlCar(MOVE);
        raceCar.movementControlCar(MOVE);

        int resultNum = raceCar.getCntMovementOfCar();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(2);
        assertThat(rasultStr).isEqualTo("--");
    }

    @DisplayName("자동차의 이동을 제어한다._3")
    @Test
    void movementControlCar_3() {
        // when
        raceCar.movementControlCar(MOVE);
        raceCar.movementControlCar(MOVE);
        raceCar.movementControlCar(MOVE);

        int resultNum = raceCar.getCntMovementOfCar();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(3);
        assertThat(rasultStr).isEqualTo("---");
    }

    @DisplayName("자동차의 이동을 제어한다._4")
    @Test
    void movementControlCar_4() {
        // when
        raceCar.movementControlCar(MOVE);
        raceCar.movementControlCar(MOVE);
        raceCar.movementControlCar(STOP);

        int resultNum = raceCar.getCntMovementOfCar();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(2);
        assertThat(rasultStr).isEqualTo("--");
    }

    @DisplayName("자동차의 움직여도 되는 조건 이 맞는가. (4이상, 9이하)")
    @Test
    void isMovementCondition() {
        // when
        boolean result = raceCar.isMovementCondition(MOVE);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("차동차의 이동을 할때 차의 이동량과 이동을 위한 출력문자를 수정, 이동시 전진 카운터 증가.")
    @Test
    void moveForward() {
        // given

        // when

        // then
    }
}