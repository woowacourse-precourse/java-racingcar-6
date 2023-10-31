package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
