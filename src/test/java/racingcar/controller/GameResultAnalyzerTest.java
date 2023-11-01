package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.helper.SubNumberGenerator;
import racingcar.model.Car;
import racingcar.util.NumberGenerator;

class GameResultAnalyzerTest {
    @Test
    void 우승자_결정() {
        // given
        List<Car> cars = new ArrayList<>();

        NumberGenerator fixNumberGenerator3 = new SubNumberGenerator(3);
        NumberGenerator fixNumberGenerator5 = new SubNumberGenerator(5);
        NumberGenerator fixnumberGenerator2 = new SubNumberGenerator(2);

        cars.add(new Car("Car1"));
        cars.add(new Car("Car2"));
        cars.add(new Car("Car3"));
        cars.add(new Car("Car4"));

        cars.get(0).move(fixNumberGenerator5);
        cars.get(1).move(fixNumberGenerator3);
        cars.get(2).move(fixNumberGenerator5);
        cars.get(3).move(fixnumberGenerator2);

        // when
        List<Car> winners = GameResultAnalyzer.determineWinners(cars);

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("Car1");
        assertThat(winners.get(1).getName()).isEqualTo("Car3");
    }
}