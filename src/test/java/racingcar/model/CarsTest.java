package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

class CarsTest {
    List<Car> carList;
    Cars cars;
    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
         carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
         cars = new Cars(carList);
        numberGenerator = new RandomNumberGenerator();
    }

    @Test
    void 전진한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.forward(numberGenerator);
                    assertAll(
                            () -> assertThat(cars.getCars().get(0).getPoint()).isEqualTo(1),
                            () -> assertThat(cars.getCars().get(1).getPoint()).isEqualTo(1),
                            () -> assertThat(cars.getCars().get(2).getPoint()).isEqualTo(0)
                    );

                },
                5, 4, 3
        );
    }
}