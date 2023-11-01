package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final int MOVE_FORWARD = 4;
    private static final int STOP = 3;

    private Car sut;

    @BeforeEach
    void initCar() {
        sut = new Car("test");
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    void moveForwardTest() {
        assertRandomNumberInRangeTest(sut::moveForwardRandomly, MOVE_FORWARD, MOVE_FORWARD);
        assertThat(sut).hasFieldOrPropertyWithValue("position", 1);
    }

    @DisplayName("자동차 정지 테스트")
    @Test
    void stayTest() {
        assertRandomNumberInRangeTest(sut::moveForwardRandomly, STOP, STOP);
        assertThat(sut).hasFieldOrPropertyWithValue("position", 0);
    }
}