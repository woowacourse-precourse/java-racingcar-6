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
    @Test
    @DisplayName("1~9 사이의 수를 return 하는지 테스트")
    void test_Get_Random_Number() {
        int expectedResult = gameService.getRandomNumber();
        assertTrue(expectedResult >= 1 && expectedResult <= 9);
    }
    @Test
    @DisplayName("정확한 우승자의 이름을 return")
    void test_Winner_Name_Return() {
        List<String> expectedCarList = Arrays.asList("woni");
        assertEquals(expectedCarList, gameService.calcWinner(testCarList));
    }
    @Test
    @DisplayName("우승자가 여러명일경우 다수 우승자 이름 return")
    void test_Winner_Name_Return_Over_2() {
        List<Car> testCarList = Arrays.asList(new Car("pobi",5),new Car("woni",5),new Car("jun", 5));
        List<String> expectedCarList = Arrays.asList("pobi", "woni", "jun");
        assertEquals(expectedCarList, gameService.calcWinner(testCarList));
    }
    @Test
    @DisplayName("가장 높은 location 값을 return")
    void test_Get_Max_Location() {
        int expectedResult = 2;
        assertEquals(expectedResult,gameService.getMaxLocation(testCarList));
    }
}