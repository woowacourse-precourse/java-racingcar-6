package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Cars;

public class CarControllerTest {
    @Test
    void 우승자_검증() {
        List<Car> carsTemp = new ArrayList<>();
        Car testCarA = new Car("a");
        Car testCarB = new Car("b");

        carsTemp.add(testCarA);
        carsTemp.add(testCarB);

        Cars cars = new Cars(carsTemp);

        testCarA.forward();

        String winner = cars.getWinner(cars);

        assertThat(winner).isEqualTo(testCarA.getMember());
    }

    @Test
    void 자동차이름_구분_검증() {
        String tempCarsString= "a,b,c";

        Cars cars = Cars.createCarsFromInputString(tempCarsString);

        assertEquals(3, cars.size());
    }
}
