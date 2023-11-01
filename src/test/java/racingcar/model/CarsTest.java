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
    Cars cars;
    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
         cars = new Cars(
                 List.of(new Car("pobi"), new Car("woni"), new Car("jun"))
         );
        numberGenerator = new RandomNumberGenerator();
    }

    @Test
    void 전진한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.forward(numberGenerator);
                    assertAll(
                            () -> assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1),
                            () -> assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1),
                            () -> assertThat(cars.getCars().get(2).getPosition()).isEqualTo(0)
                    );

                },
                5, 4, 3
        );
    }
}