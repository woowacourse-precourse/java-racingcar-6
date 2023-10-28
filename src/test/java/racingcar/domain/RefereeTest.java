package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RefereeTest {
    @Test
    void 단일_우승자_반환_테스트() {
        List<Car> cars = new ArrayList<>();
        Referee referee = new Referee();
        for (int i = 0; i < 3; i++) {
            cars.add(new Car("test" + i));
        }

        cars.get(0).move();
        List<Car> winners = referee.getWinner(cars);
        Assertions.assertThat(winners.size()).isEqualTo(1);
        Assertions.assertThat(winners.get(0).getName()).isEqualTo("test0");
    }

    @Test
    void 복수_우승자_반환_테스트() {
        List<Car> cars = new ArrayList<>();
        Referee referee = new Referee();
        for (int i = 0; i < 3; i++) {
            cars.add(new Car("test" + i));
        }

        cars.get(0).move();
        cars.get(1).move();
        List<Car> winners = referee.getWinner(cars);
        Assertions.assertThat(winners.size()).isEqualTo(2);
    }
}