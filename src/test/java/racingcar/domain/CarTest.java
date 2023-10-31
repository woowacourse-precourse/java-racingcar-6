package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.Car.createCar;
import static racingcar.domain.Car.createZeroProgressCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

class CarTest {

    @DisplayName("자동차 전진 테스트")
    @Test
    void testMoveForward() {
        int initProgress = 2;
        Car car = createCar("car A", initProgress);

        car.moveForward();

        assertEquals(initProgress + 1, car.getProgress());
    }

    @DisplayName("progress(전진)바 출력 테스트")
    @Test
    void printProgressBar() {
        Car car = createCar("car A", 4);

        OutputView outputView = new OutputView();
        String progressBar = outputView.printProgressBar(car.getProgress());

        assertEquals("----", progressBar);
    }

    @DisplayName("자동차 이름은 5자 미만이어야 한다 테스트")
    @Test
    void validateCarName() {
        assertThrows(IllegalArgumentException.class, () -> createZeroProgressCar("abcdef"));
    }
}