package racingcar.sevice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.manager.Validator;

class GameServiceTest {
    List<Car> carList;
    Validator validator = new Validator();
    GameService gameService = new GameService(validator);
    @BeforeEach
    void setup(){
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
}