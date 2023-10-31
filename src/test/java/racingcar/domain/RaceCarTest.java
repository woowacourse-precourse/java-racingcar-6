package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RaceCarTest {
    private final int MOVE = 4;
    private final int STOP = 0;
    private RaceCar raceCar;

    @BeforeEach
    void setUp() {
        raceCar = new RaceCar("Test");
    }

    private void moveRaceCar(RaceCar raceCar) {
        raceCar.movementControl(MOVE);
    }

    @DisplayName("자동차의 이동을 제어한다.")
    @Test
    void movementControlCar() {
        // when
        raceCar.movementControl(MOVE);

        int resultNum = raceCar.getCntMovement();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(1);
        assertThat(rasultStr).isEqualTo("-");
    }

    @DisplayName("자동차의 이동을 제어한다._2")
    @Test
    void movementControlCar_2() {
        // when
        raceCar.movementControl(MOVE);
        raceCar.movementControl(MOVE);

        int resultNum = raceCar.getCntMovement();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(2);
        assertThat(rasultStr).isEqualTo("--");
    }

    @DisplayName("자동차의 이동을 제어한다._3")
    @Test
    void movementControlCar_3() {
        // when
        raceCar.movementControl(MOVE);
        raceCar.movementControl(MOVE);
        raceCar.movementControl(MOVE);

        int resultNum = raceCar.getCntMovement();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(3);
        assertThat(rasultStr).isEqualTo("---");
    }

    @DisplayName("자동차의 이동을 제어한다._4")
    @Test
    void movementControlCar_4() {
        // when
        raceCar.movementControl(MOVE);
        raceCar.movementControl(MOVE);
        raceCar.movementControl(STOP);

        int resultNum = raceCar.getCntMovement();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(2);
        assertThat(rasultStr).isEqualTo("--");
    }

    @DisplayName("자동차의 움직여도 되는 조건 이 맞는가. (4이상, 9이하)")
    @Test
    void isMovementCondition() {
        // when
        boolean result = raceCar.isMovement(MOVE);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("자동차의 움직여도 되는 조건 이 맞는가. (4이상, 9이하)_2")
    @Test
    void isMovementCondition_2() {
        // when
        boolean result = raceCar.isMovement(STOP);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("차동차의 이동을 할때 차의 이동량과 이동을 위한 출력문자를 수정, 이동시 전진 카운터 증가.")
    @Test
    void moveForward() {
        // when
        raceCar.moveForward();

        int resultNum = raceCar.getCntMovement();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(1);
        assertThat(rasultStr).isEqualTo("-");
    }

    @DisplayName("차동차의 이동을 할때 차의 이동량과 이동을 위한 출력문자를 수정, 이동시 전진 카운터 증가._2")
    @Test
    void moveForward_2() {
        // when
        raceCar.moveForward();
        raceCar.moveForward();

        int resultNum = raceCar.getCntMovement();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(2);
        assertThat(rasultStr).isEqualTo("--");
    }

    @DisplayName("차동차의 이동을 할때 차의 이동량과 이동을 위한 출력문자를 수정, 이동시 전진 카운터 증가._3")
    @Test
    void moveForward_3() {
        // when
        raceCar.moveForward();
        raceCar.moveForward();
        raceCar.moveForward();

        int resultNum = raceCar.getCntMovement();
        String rasultStr = raceCar.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(3);
        assertThat(rasultStr).isEqualTo("---");
    }
}