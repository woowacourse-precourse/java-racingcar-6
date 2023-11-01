package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Judge;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

class JudgeTest {
    Judge judge;
    List<Car> cars;
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void setUp() {
        car1 = new Car("amy",4);
        car2 = new Car("lisa",3);
        car3 = new Car("rose",4);
        cars= new ArrayList<>();

        judge = new Judge();
    }

    @Test
    @DisplayName("우승자 한 명일 때")
    public void isOnlyOneWinner() {
        cars.add(car1);
        cars.add(car2);

        List<Car> actual = judge.findWinner(cars);
        List<Car> expected = new ArrayList<>();
        expected.add(car1);

        Assertions.assertIterableEquals(actual, expected);
    }

    @Test
    @DisplayName("우승자 여러 명일 때")
    public void isMultipleWinners() {
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> actual = judge.findWinner(cars);
        List<Car> expected = new ArrayList<>();
        expected.add(car1);
        expected.add(car3);

        Assertions.assertIterableEquals(actual, expected);
    }

}