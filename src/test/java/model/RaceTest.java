package model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

public class RaceTest {

    // findWinners 테스트
    @Test
    void 우승자_테스트() {
        //given
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );

        // when
        // pobi 전진
        cars.get(0).forward();

        // woni 전진
        cars.get(1).forward();
        cars.get(1).forward();
        cars.get(1).forward();

        // jun 전진
        cars.get(2).forward();
        cars.get(2).forward();

        Race race = new Race(cars);

        // then
        Assertions.assertThat(race.findWinners()).isEqualTo(List.of(cars.get(1)));
    }

    @Test
    void 우승자_중복_테스트() {
        //given
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );

        // when
        // pobi 전진
        cars.get(0).forward();

        // woni 전진
        cars.get(1).forward();

        // jun 전진
        cars.get(2).forward();

        Race race = new Race(cars);

        // then
        Assertions.assertThat(race.findWinners()).isEqualTo(
                List.of(cars.get(0),
                        cars.get(1),
                        cars.get(2)));
    }
}
