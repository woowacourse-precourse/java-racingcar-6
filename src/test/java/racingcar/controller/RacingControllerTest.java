package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingControllerTest {

    @Test
    @DisplayName("랜덤한 수별로 이동 처리하기")
    public void testmoveCar() {
        //given
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        //when
        RacingController.manageCarMovement(car1, 4); // move
        RacingController.manageCarMovement(car2, 3); // stop

        //then
        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차 계산하기")
    public void testfindRacingWinners() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("CarA"));
        cars.add(new Car("CarB"));
        cars.add(new Car("CarC"));
        cars.add(new Car("CarD"));

        for (int i = 0; i < 3; i++) {
            cars.get(0).moveCar();
            cars.get(2).moveCar();
        }
        cars.get(1).moveCar();

        //when
        List<String> result = RacingController.findRacingWinners(cars);

        //then
        List<String> expected = List.of("CarA", "CarC");
        Assertions.assertThat(result).isEqualTo(expected);
    }
}