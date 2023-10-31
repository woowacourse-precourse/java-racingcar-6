package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarsTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = List.of(new Car("Car1"), new Car("Car2"), new Car("Car3"));
        cars.get(0).moveForward();
        cars.get(1).moveForward();
    }

    @Test
    void getWinners_우승자_검증에_성공한다() {
        // given
        int maxPosition = 1;

        // when
        List<String> winners = Cars.getWinners(cars, maxPosition);

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).containsExactly("Car1", "Car2");
        assertThat(winners).doesNotContain("Car3");
    }
}


