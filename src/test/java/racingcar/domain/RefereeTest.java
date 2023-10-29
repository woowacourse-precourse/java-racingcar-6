package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    void 단독우승자인경우() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi",4));
        cars.add(new Car("woni",3));
        cars.add(new Car("jun",2));

        List<String> answer = Referee.determineWinner(cars);
        List<String> expected = List.of("pobi");
        assertThat(answer).isEqualTo(expected);
    }

}