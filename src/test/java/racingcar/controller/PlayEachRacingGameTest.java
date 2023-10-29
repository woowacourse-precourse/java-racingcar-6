package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayEachRacingGameTest {

    List<Car> cars;
    PlayEachRacingGame playEachRacingGame=new PlayEachRacingGameImpl();

    @BeforeEach
    void setCars(){
        Car car1=new Car("pobi");
        Car car2=new Car("woni");
        Car car3=new Car("jun");

        cars=new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

    }

    @Test
    void 각각_레이스_시작(){

        assertRandomNumberInRangeTest(
                () -> {
                    cars=playEachRacingGame.getPlayEachRacingGame(cars);
                },
                4, 3,2
        );

        Assertions.assertThat(cars.get(0).getMoveCount()).isEqualTo(1);
        Assertions.assertThat(cars.get(1).getMoveCount()).isEqualTo(0);
        Assertions.assertThat(cars.get(2).getMoveCount()).isEqualTo(0);

        assertRandomNumberInRangeTest(
                () -> {
                    cars=playEachRacingGame.getPlayEachRacingGame(cars);
                },
                6, 5,2
        );

        Assertions.assertThat(cars.get(0).getMoveCount()).isEqualTo(2);
        Assertions.assertThat(cars.get(1).getMoveCount()).isEqualTo(1);
        Assertions.assertThat(cars.get(2).getMoveCount()).isEqualTo(0);
    }
}
