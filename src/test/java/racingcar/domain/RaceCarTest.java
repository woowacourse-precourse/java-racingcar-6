package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.StringAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

class RaceCarTest {
    private final int MOVE = 4;
    private final int STOP = 0;
    private RaceCar raceCar1;
    private RaceCar raceCar2;
    private RaceCar raceCar3;

    @BeforeEach
    void setUp() {
        raceCar1 = new RaceCar("Test");
        raceCar2 = new RaceCar("seung");
        raceCar3 = new RaceCar("chan");
    }

    private void moveRaceCar(RaceCar raceCar) {
        raceCar.movementControl(MOVE);
    }

    @DisplayName("자동차의 이동을 제어한다.")
    @Test
    void movementControlCar() {
        // when
        raceCar1.movementControl(MOVE);

        int resultNum = raceCar1.getCntMovement();
        String rasultStr = raceCar1.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(1);
        assertThat(rasultStr).isEqualTo("-");
    }

    @DisplayName("자동차의 이동을 제어한다._2")
    @Test
    void movementControlCar_2() {
        // when
        raceCar1.movementControl(MOVE);
        raceCar1.movementControl(MOVE);

        int resultNum = raceCar1.getCntMovement();
        String rasultStr = raceCar1.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(2);
        assertThat(rasultStr).isEqualTo("--");
    }

    @DisplayName("자동차의 이동을 제어한다._3")
    @Test
    void movementControlCar_3() {
        // when
        raceCar1.movementControl(MOVE);
        raceCar1.movementControl(MOVE);
        raceCar1.movementControl(MOVE);

        int resultNum = raceCar1.getCntMovement();
        String rasultStr = raceCar1.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(3);
        assertThat(rasultStr).isEqualTo("---");
    }

    @DisplayName("자동차의 이동을 제어한다._4")
    @Test
    void movementControlCar_4() {
        // when
        raceCar1.movementControl(MOVE);
        raceCar1.movementControl(MOVE);
        raceCar1.movementControl(STOP);

        int resultNum = raceCar1.getCntMovement();
        String rasultStr = raceCar1.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(2);
        assertThat(rasultStr).isEqualTo("--");
    }

    @DisplayName("자동차의 움직여도 되는 조건 이 맞는가. (4이상, 9이하)")
    @Test
    void isMovementCondition() {
        // when
        boolean result = raceCar1.isMovement(MOVE);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("자동차의 움직여도 되는 조건 이 맞는가. (4이상, 9이하)_2")
    @Test
    void isMovementCondition_2() {
        // when
        boolean result = raceCar1.isMovement(STOP);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("차동차의 이동을 할때 차의 이동량과 이동을 위한 출력문자를 수정, 이동시 전진 카운터 증가.")
    @Test
    void moveForward() {
        // when
        raceCar1.moveForward();

        int resultNum = raceCar1.getCntMovement();
        String rasultStr = raceCar1.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(1);
        assertThat(rasultStr).isEqualTo("-");
    }

    @DisplayName("차동차의 이동을 할때 차의 이동량과 이동을 위한 출력문자를 수정, 이동시 전진 카운터 증가._2")
    @Test
    void moveForward_2() {
        // when
        raceCar1.moveForward();
        raceCar1.moveForward();

        int resultNum = raceCar1.getCntMovement();
        String rasultStr = raceCar1.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(2);
        assertThat(rasultStr).isEqualTo("--");
    }

    @DisplayName("차동차의 이동을 할때 차의 이동량과 이동을 위한 출력문자를 수정, 이동시 전진 카운터 증가._3")
    @Test
    void moveForward_3() {
        // when
        raceCar1.moveForward();
        raceCar1.moveForward();
        raceCar1.moveForward();

        int resultNum = raceCar1.getCntMovement();
        String rasultStr = raceCar1.toStringMoveState();

        // then
        assertThat(resultNum).isEqualTo(3);
        assertThat(rasultStr).isEqualTo("---");
    }

    @DisplayName("차동차의 이동을 할때 차의 이동량과 이동을 위한 출력문자를 수정, 이동시 전진 카운터 증가._4")
    @Test
    void moveForward_4() {
        // given
        List<RaceCar> list = List.of(raceCar1, raceCar2, raceCar3);

        // when
        for (int i = 0; i < 3; i++) {
            list.forEach(raceCar -> raceCar.moveForward());
        }

        // then
        assertThat(list).allSatisfy(raceCar -> raceCar.getCntMovement().compareTo(3));
    }
}