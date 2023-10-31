package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private Referee referee;
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {

        referee = new Referee();

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(true);
        car2.move(false);

        cars.add(car1);
        cars.add(car2);
    }

    @Test
    void selectOneWinnerTest() {

        String winners = referee.selectWinner(cars);

        assertThat(winners).isEqualTo("car1");
    }

    @Test
    void selectTwoWinnerTest() {

        Car car3 = new Car("car3");
        car3.move(true);
        cars.add(car3);

        String winners = referee.selectWinner(cars);

        assertThat(winners).isEqualTo("car1, car3");
    }
}