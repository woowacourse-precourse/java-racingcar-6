package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

class RefereeTest {
    private Car car1, car2, car3;
    private Referee referee;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");

        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        referee = new Referee(cars);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,3", "5,5,3,5"})
    void maxDistance(int car1Distance, int car2Distance, int car3Distance, int expectedMax) {
        car1.distance = car1Distance;
        car2.distance = car2Distance;
        car3.distance = car3Distance;

        Assertions.assertEquals(referee.maxDistance(cars), expectedMax);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;2;3;car3", "5;5;3;car1, car2"}, delimiter = ';')
    void whoIsWinner(int car1Distance, int car2Distance, int car3Distance, String expected) {
        car1.distance = car1Distance;
        car2.distance = car2Distance;
        car3.distance = car3Distance;

        Assertions.assertEquals(referee.whoIsWinner(), expected);
    }
}