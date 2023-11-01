package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarServiceTest {
    RacingCarService racingCarService = new RacingCarService();
    @DisplayName("(0, 9)사이로 발생시킨 난수가 4 이상이면 moveCount 추가")
    @Test
    void testOperateCar1(){
        int moveNum = 4;
        String carName = "pobi";
        int moveCount = 0;

        RacingCar car = new RacingCar();
        car.setName(carName);
        car.setMoveCount(moveCount);

        assertMoveCount(car, moveNum, 1);

        int moveNum2 = 9;
        String carName2 = "woni";
        int moveCount2 = 1;

        RacingCar car2 = new RacingCar();
        car2.setName(carName2);
        car2.setMoveCount(moveCount2);

        assertMoveCount(car2, moveNum2, 2);
    }

    @DisplayName("(0, 9)사이로 발생시킨 난수가 4 미만이면 moveCount 그대로")
    @Test
    void testOperateCar2(){
        int moveNum = 0;
        String carName = "pobi";
        int moveCount = 0;

        RacingCar car = new RacingCar();
        car.setName(carName);
        car.setMoveCount(moveCount);

        assertMoveCount(car, moveNum, 0);
    }

    private void assertMoveCount(RacingCar car, int moveNum, int expectedMoveCount){
        RacingCar expectedCar = racingCarService.operateCar(car, moveNum);

        int realMoveCount = expectedCar.getMoveCount();

        assertEquals(expectedMoveCount, realMoveCount);
    }

    @DisplayName("RacingCars의 객체 중 moveCount가 가장 큰 객체의 이름을 리스트에 담아 반환")
    @Test
    void findTheLeaderTest(){
        String carName = "pobi";
        int moveCount = 3;
        RacingCar car = new RacingCar();
        car.setName(carName);
        car.setMoveCount(moveCount);

        List<RacingCar> testCars = new ArrayList<>();
        testCars.add(car);

        List<String> leaders = racingCarService.findTheLeaders(testCars);
        assertThat(leaders).contains("pobi");

        String carName3 = "windy";
        int moveCount3 = 6;
        RacingCar car3 = new RacingCar();
        car3.setName(carName3);
        car3.setMoveCount(moveCount3);

        String carName4 = "fast";
        int moveCount4 = 5;
        RacingCar car4 = new RacingCar();
        car4.setName(carName4);
        car4.setMoveCount(moveCount4);

        List<RacingCar> testCars2 = new ArrayList<>();
        testCars2.add(car3);
        testCars2.add(car4);

        List<String> leaders2 = racingCarService.findTheLeaders(testCars2);
        assertThat(leaders2).contains("windy");
    }

    @DisplayName("RacingCars의 객체 중 moveCount가 가장 큰 여러개라면 해당 객체의 이름 모두를 리스트에 담아 반환")
    @Test
    void findTheLeaderTest2(){
        String carName = "pobi";
        int moveCount = 3;
        RacingCar car = new RacingCar();
        car.setName(carName);
        car.setMoveCount(moveCount);

        String carName2 = "woni";
        int moveCount2 = 3;
        RacingCar car2 = new RacingCar();
        car2.setName(carName2);
        car2.setMoveCount(moveCount2);

        List<RacingCar> testCars = new ArrayList<>();
        testCars.add(car);
        testCars.add(car2);

        List<String> leaders = racingCarService.findTheLeaders(testCars);
        assertThat(leaders).contains("woni", "pobi");
        assertThat(leaders).containsExactly("pobi", "woni");
    }
}
