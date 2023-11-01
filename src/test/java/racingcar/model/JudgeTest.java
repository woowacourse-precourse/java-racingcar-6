package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.view.JudgeView;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;


public class JudgeTest {

    @Test
    void 우승자_결정_다수의_우승자() {

        List<Car> cars = new ArrayList<>();
        cars.add(Car.nameOf("car1"));
        cars.add(Car.nameOf("car2"));
        cars.add(Car.nameOf("car3"));

        List<Car> winners = Judge.determineWinners(cars);
        JudgeView.printWinners(winners);

        assertThat(winners).contains(cars.toArray(new Car[0]));
    }

    @Test
    void 우승자_결정_1명의_우승자() {

        List<Car> cars = new ArrayList<>();
        cars.add(Car.nameOf("car1"));

        List<Car> winners = Judge.determineWinners(cars);
        JudgeView.printWinners(winners);

        assertThat(winners).contains(cars.toArray(new Car[0]));
    }

}