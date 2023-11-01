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

    @Test
    void 단독_우승자를_판단한다() {
        assertRandomNumberInRangeTest(
                () -> cars.forward(numberGenerator),
                5, 3, 3
        );
        Cars winner = cars.judgeWinner();
        assertAll(
                () -> assertThat(winner.getCars().size()).isEqualTo(1),
                () -> assertThat(winner.getCars().get(0).getName()).isEqualTo("pobi"),
                () -> assertThat(winner.getCars().get(0).getPosition()).isEqualTo(1)
        );
    }

    @Test
    void 공동_우승자를_판단한다() {
        assertRandomNumberInRangeTest(
                () -> cars.forward(numberGenerator),
                5, 4, 3
        );
        Cars winners = cars.judgeWinner();
        assertAll(
                () -> assertThat(winners.getCars().size()).isEqualTo(2),
                () -> assertThat(winners.getCars().get(0).getName()).isEqualTo("pobi"),
                () -> assertThat(winners.getCars().get(0).getPosition()).isEqualTo(1),
                () -> assertThat(winners.getCars().get(1).getName()).isEqualTo("woni"),
                () -> assertThat(winners.getCars().get(1).getPosition()).isEqualTo(1)
        );
    }
}