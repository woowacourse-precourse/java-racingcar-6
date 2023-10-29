package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class FindWinnerTest {

    List<Car> cars;
    PlayEachRacingGame playEachRacingGame=new PlayEachRacingGameImpl();
    FindWinners findWinners = new FindWinnersImpl();

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
    void 단독_우승자(){
        assertRandomNumberInRangeTest(
                () -> {
                    cars=playEachRacingGame.getPlayEachRacingGame(cars);
                },
                4, 3,2
        );

        List<Integer> result=findWinners.getWinner(cars);

        Assertions.assertThat(result).containsExactly(0);
    }

    @Test
    void 공동_우승자(){
        assertRandomNumberInRangeTest(
                () -> {
                    cars=playEachRacingGame.getPlayEachRacingGame(cars);
                },
                4, 3,7
        );

        List<Integer> result=findWinners.getWinner(cars);

        Assertions.assertThat(result).containsExactly(0,2);
    }

}
