package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    private Race race;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("A"), new Car("B"), new Car("C"));
        race = new Race(cars, 3);
    }

    @Test
    void Race_객체_정상적으로_생성() {
        assertThat(race).isNotNull();
    }

    @Test
    void 레이스_종료_여부_확인() {
        for (int i = 0; i < 3; i++) {
            race.raceRound();
        }
        assertThat(race.isFinished()).isTrue();
    }

    @Test
    void 최대_위치의_자동차_확인() {
        cars.get(0).move(4);
        cars.get(1).move(0);
        cars.get(2).move(0);

        List<Car> maxPositionCar = race.getWinner();

        assertThat(maxPositionCar.get(0).getCarStatus()).isEqualTo(cars.get(0).getCarStatus());
    }

    @Test
    void 우승자_반환_로직_검증() {
        cars.get(0).move(4);
        cars.get(1).move(0);
        cars.get(2).move(0);

        cars.get(0).move(0);
        cars.get(1).move(4);
        cars.get(2).move(0);

        List<Car> winners = race.getWinner();

        assertThat(winners).containsExactlyInAnyOrder(cars.get(0), cars.get(1));
    }
}
