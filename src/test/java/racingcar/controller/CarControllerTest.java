package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarControllerTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final List<String> CAR_LIST = new ArrayList<>(Arrays.asList("pobi", "woni", "blur"));
    CarController carController;

    @BeforeEach
    void reset() {
        carController = CarController.createCars(CAR_LIST);
    }

    @Test
    @DisplayName("setCarsName 후 toString 출력 확인")
    void testSetCarsName() {
        assertThat(carController.toString()).contains("pobi : ", "woni : ", "blur : ");
    }

    @Test
    @DisplayName("우승자 한명 일 경우 chooseWinner() 반환값 확인")
    void testChooseWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    carController.ifForwardCars();
                    assertThat(carController.chooseWinner()).isEqualTo("woni");
                },
                STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("우승자 세 명 일 경우 chooseWinner() 반환값 확인")
    void testChooseThreeWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    carController.ifForwardCars();
                    assertThat(carController.chooseWinner()).isEqualTo("pobi, woni, blur");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }
}