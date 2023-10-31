package racingcar.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Nested
    class SingleWinnerTests {
        @ParameterizedTest
        @CsvSource({"4,3,2,pobi", "1,2,3,jun", "2,5,4,woni"})
        void 단독우승자인경우(int pobiDistance, int woniDistance, int junDistance, String expectedWinners) {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("pobi", pobiDistance));
            cars.add(new Car("woni", woniDistance));
            cars.add(new Car("jun", junDistance));

            List<String> answer = Referee.determineWinner(cars);
            List<String> expected = List.of(expectedWinners);
            assertThat(answer).isEqualTo(expected);
        }
    }

    @Nested
    class MultipleWinnersTests {
        @ParameterizedTest
        @CsvSource(value = {"4:4:4:pobi,woni,jun", "4:2:4:pobi,jun", "0:1:1:woni,jun"}, delimiter = ':')
        void 공동우승자인경우(int pobiDistance, int woniDistance, int junDistance, String expectedWinners) {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("pobi", pobiDistance));
            cars.add(new Car("woni", woniDistance));
            cars.add(new Car("jun", junDistance));

            List<String> answer = Referee.determineWinner(cars);
            List<String> expected = List.of(expectedWinners.split(","));
            assertThat(answer).isEqualTo(expected);
        }
    }

}