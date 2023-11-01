package controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.controller.CarController;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarControllerTest {
    private CarController carController = new CarController();

    @Test
    void 우승자_검증() {
        List<Car> carsTemp = new ArrayList<>();
        Car testCarA = new Car("a");
        Car testCarB = new Car("b");

        carsTemp.add(testCarA);
        carsTemp.add(testCarB);

        Cars cars = new Cars(carsTemp);

        testCarA.forward();

        String winner = carController.getWinner(cars);

        assertThat(winner).isEqualTo(testCarA.getMember());
    }

}
