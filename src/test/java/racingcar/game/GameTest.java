package racingcar.game;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = new Game();
    @Test
    void findMaxScore() {
        Car car1 = new Car("hello",0);
        Car car2 = new Car("world",5);
        Car car3 = new Car("race",4);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        assertThat(game.findMaxScore(carList)).isEqualTo(5);
    }

    @Test
    void winner() {
        Car car1 = new Car("hello",0);
        Car car2 = new Car("world",5);
        Car car3 = new Car("race",4);
        Car car4 = new Car("start",5);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        List<String> result = List.of(new String[]{"world", "start"});
        assertThat(game.winner(carList,5)).isEqualTo(result);
    }
    @Test
    void zero_score_winner() {
        Car car1 = new Car("hello",0);
        Car car2 = new Car("world",0);
        Car car3 = new Car("race",0);
        Car car4 = new Car("start",0);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        List<String> result = List.of(new String[]{"hello","world","race","start"});
        assertThat(game.winner(carList,0)).isEqualTo(result);
    }
}