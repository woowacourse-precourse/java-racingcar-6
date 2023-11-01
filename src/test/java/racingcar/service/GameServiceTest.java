package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameServiceTest {
    private GameService gameService = new GameService();
    List<Car> testCarList = Arrays.asList(new Car("pobi",1), new Car("woni",2));
    @Test
    @DisplayName("String을 ',' 기준으로 나누어서 저장하는지 테스트")
    void test_Split_Car_Name() {
        List<String> expectedResult = Arrays.asList("pobi","woni");
        assertEquals(expectedResult, gameService.splitCarNames("pobi,woni"));
    }
}