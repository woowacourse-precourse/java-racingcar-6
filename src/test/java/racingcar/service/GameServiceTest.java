package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.manager.Validator;
import racingcar.sevice.GameService;

class GameServiceTest {

    List<Car> carList;
    Validator validator = new Validator();
    GameService gameService = new GameService(validator);

    @BeforeEach
    void setup() {
        carList = new ArrayList<>();
        Car car1 = new Car("test");
        Car car2 = new Car("hello");

        carList.add(car1);
        carList.add(car2);
    }

    @Test
    @DisplayName("자동차 레이싱 우승자 정상 추출")
    void extractWinnerSuccess() {
        List<Car> winners = gameService.extractWinner(carList);
        assertEquals(2, winners.size());
        assertEquals("test", winners.get(0).getName());
        assertEquals("hello", winners.get(1).getName());
    }

    @Test
    @DisplayName("string 배열에서 자동차 등록")
    void registerCarFromListSuccess() {
        String[] input = {"test", "hello"};
        List<Car> registerCars = gameService.registerCarListFromInput(input);

        assertEquals(2, registerCars.size());
        assertEquals(input[0], registerCars.get(0).getName());
        assertEquals(input[1], registerCars.get(1).getName());
    }
}