package racingcar;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import random.Random;
import service.CarService;
import service.GameService;
import util.Parser;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class FunctionTest {
    GameService gameService = new GameService();
    CarService carService = new CarService();

    @Test
    @DisplayName("한줄로 받은 이름들을 , 를 기준으로 나누는 기능")
    void split() { // 고쳐야됨
        String input = "pobi,jun,son";
        List<String> result = Parser.split(input);
        assertThat(result).containsExactly("pobi", "jun", "son");
    }

    @Test
    @DisplayName("각 자동차를 생성하는 기능")
    void createCars() {
        List<String> carNames = Arrays.asList("pobi", "jun", "son");
        List<Car> cars = carService.createCars(carNames);
        assertThat(cars).extracting(Car::getName)
                .usingRecursiveComparison()
                .isEqualTo(carNames);
    }

    @Test
    @DisplayName("자동차가 전진라고 판별 내렸을때 움직임 저장되는 기능")
    void go() {
        Car car = new Car("pobi", 2, new Random(5, 6));
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차가 정지라고 판별 내렸을때 움직임 저장되는 기능")
    void stop() {
        Car car = new Car("pobi", 2, new Random(1, 3));
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("승자를 찾는 기능")
    void findWinner() {
        List<Car> cars = Arrays.asList(new Car("son", 3), new Car("jun", 4), new Car("pobi", 4));
        List<String> winner = gameService.findWinner(cars);
        assertThat(winner).containsExactly("jun", "pobi");
    }

}

