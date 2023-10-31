package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class GameTest {


    @Test
    @DisplayName("자동차의 위치가 각기 다르다면 위치가 가장 큰 자동차(들)이 우승한다.")
    void getWinnerWithDifferentPosition() {
        Car pobiCar = new Car("pobi", 100);
        Car woniCar = new Car("woni", 200);
        Car junCar = new Car("jun", 200);
        Car jakeCar = new Car("jake", 150);

        List<Car> carList = List.of(pobiCar, woniCar, junCar, jakeCar);

        Cars cars = new Cars(carList);
        Game game = new Game(cars, 1);

        List<Car> winners = game.getWinners();
        Assertions.assertThat(winners.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차의 위치가 모두 동일하게 0 이라면 모든 자동차들이 우승한다.")
    void getWinnerWithSamePosition() {
        Car pobiCar = new Car("pobi", 0);
        Car woniCar = new Car("woni", 0);
        Car junCar = new Car("jun", 0);
        Car jakeCar = new Car("jake", 0);

        List<Car> carList = List.of(pobiCar, woniCar, junCar, jakeCar);

        Cars cars = new Cars(carList);
        Game game = new Game(cars, 1);

        List<Car> winners = game.getWinners();
        Assertions.assertThat(winners.size()).isEqualTo(4);
    }
}
