package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceCarTest {
    private RaceCar raceCar;

    @BeforeEach
    void setUp() {
        raceCar = new RaceCar("Test");
    }

    @DisplayName("자동차의 이동을 제어한다.")
    @Test
    void movementControlCar() {
        // given

        // when

        // then
    }

    @DisplayName("자동차의 움직여도 되는 조건 이 맞는가. (4이상, 9이하)")
    @Test
    void isMovementCondition() {
        // given

        // when

        // then
    }

    @DisplayName("차동차의 이동을 할때 차의 이동량과 이동을 위한 출력문자를 수정, 이동시 전진 카운터 증가.")
    @Test
    void moveForward() {
        // given

        // when

        // then
    }
}