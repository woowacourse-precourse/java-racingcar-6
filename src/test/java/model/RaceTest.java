package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

public class RaceTest {

    // setCarsFromNames() 테스트
    @Test
    void names_개수_만큼_생성되는지_확인() {
        // given % when
        Race race1 = new Race(Arrays.asList("pobi", "woni", "jun"));
        Race race2 = new Race(Arrays.asList("pobi", "woni", "jun", "lee", "sun"));

        // then
        assertThat(race1.getCarSize()).isEqualTo(3);
        assertThat(race2.getCarSize()).isEqualTo(5);
    }

    // carForward 테스트
    @Test
    void 설정된_랜덤값_보다_작을때_전진하는지_테스트() {
        //given
        Race race = new Race(List.of("pobi"));

        List<Car> cars = race.getCars();
        race.forwardCar(cars.get(0), 1);
        race.forwardCar(cars.get(0), 2);
        race.forwardCar(cars.get(0), 3);

        Assertions.assertThat(cars.get(0).getPosition()).isEqualTo(0);
    }

    @Test
    void 설정된_랜덤값_보다_크거나_같을때_전진하는지_테스트() {
        //given
        Race race = new Race(List.of("pobi"));

        List<Car> cars = race.getCars();
        race.forwardCar(cars.get(0), 4);
        race.forwardCar(cars.get(0), 5);
        race.forwardCar(cars.get(0), 6);

        Assertions.assertThat(cars.get(0).getPosition()).isEqualTo(3);
    }

    // findWinners 테스트
    @Test
    void 우승자_테스트() {
        //given
        Race race = new Race(List.of("pobi", "woni", "jun"));

        List<Car> cars = race.getCars();
        // 1번 전진
        race.forwardCar(cars.get(0), 4);

        // 3번 전진
        race.forwardCar(cars.get(1), 4);
        race.forwardCar(cars.get(1), 4);
        race.forwardCar(cars.get(1), 4);

        // 2번 전진
        race.forwardCar(cars.get(2), 4);
        race.forwardCar(cars.get(2), 4);

        Assertions.assertThat(race.findWinners()).isEqualTo(List.of(cars.get(1)));
    }

    @Test
    void 우승자_중복_테스트() {
        //given
        Race race = new Race(List.of("pobi", "woni", "jun"));

        List<Car> cars = race.getCars();
        race.forwardCar(cars.get(0), 4);

        race.forwardCar(cars.get(1), 4);

        race.forwardCar(cars.get(2), 4);

        Assertions.assertThat(race.findWinners()).isEqualTo(
                List.of(cars.get(0),
                        cars.get(1),
                        cars.get(2)));
    }
}
