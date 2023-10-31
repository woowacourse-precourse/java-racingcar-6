package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.carfactory.Car;
import racingcar.carfactory.CarFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    GameService gameService;
    CarFactory carFactory;
    public GameServiceTest(){
        carFactory = new CarFactory();
        gameService = new GameService();
    }
    @Test
    void 입력된_문자열을_올바르게_리스트로_반환(){
        List<String> carNames = gameService.inputToCarNames("nuri, pobi, woodi");

        Assertions.assertThat(carNames).contains("nuri","pobi","woodi");
    }
    @Test
    void 가장_멀리_간_승자들() {
        List<Car> cars = carFactory.
                createCars(gameService.inputToCarNames("nuri, pobi, woodi"));

        cars.get(0).advanceOnce();
        cars.get(1).advanceOnce();
        List<Car> winner = gameService.selectWinner(cars);

        Assertions.assertThat(winner.stream().map(Car::getName)).contains("nuri","pobi");
    }
}