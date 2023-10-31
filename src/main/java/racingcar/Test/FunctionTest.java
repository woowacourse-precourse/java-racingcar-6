package racingcar.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import racingcar.Computer.DetermineWinner;
import racingcar.Car.Car;
import racingcar.Car.CarMover;
import racingcar.Computer.RandomNumber;
import racingcar.Constants.CarConstants;
import racingcar.Constants.RandomNumberRange;
import java.util.Collections;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FunctionTest {
    @Test
    @DisplayName("랜덤한값을 생성하는 메서드가 0~9 사이에 범위를 반환 하는지 확인")
    void testRandomValueInRange() {
        int randomValue = RandomNumber.generate();
        assertTrue(randomValue >= RandomNumberRange.MIN_RANDOM_RANGE && randomValue <= RandomNumberRange.MAX_RANDOM_RANGE);
    }

    @Test
    @DisplayName("전진 시키는 메서드가 전진값을 0~3이면 0, 4~9이면 1을 생성하고 자동차에 보내주는지 확인")
    void testDistanceDetermination() {
        for (int i = 0; i <= 3; i++) {
            int distance = CarMover.determineMoveDistance(i);
            assertEquals(CarConstants.STOP_DISTANCE, distance);
        }
        for (int i = 4; i <= 9; i++) {
            int distance = CarMover.determineMoveDistance(i);
            assertEquals(CarConstants.MOVE_DISTANCE, distance);
        }
    }

    @Test
    @DisplayName("자동차 에게 전진 메서드 적용이 되는지 확인")
    void testApplyForwardMethodToCar() {
        Car testCar = new Car("car1");
        List<Car> carList = Collections.singletonList(testCar);
        int initialHistorySize = testCar.getPositions().size();
        CarMover.moveCars(carList);
        int finalHistorySize = testCar.getPositions().size();
        assertEquals(initialHistorySize + 1, finalHistorySize);
    }

    @Test
    @DisplayName("자동차의 위치 초기값은 모두 0으로 시작 하는지 확인")
    void testInitialPositionOfCar() {
        Car testCar = new Car("car1");
        int initialPosition = testCar.getPositions().get(0);
        assertEquals(CarConstants.START_POSITION, initialPosition);
    }

    @Test
    @DisplayName("반복실행의 결과 위치값을 누적으로 +하여 가지는지 확인.")
    void testPositionAccumulationOnMultipleMoves() {
        Car testCar = new Car("testCar");
        int expectedDistance = CarConstants.MOVE_DISTANCE;
        for (int i = 0; i < 5; i++) {
            testCar.move(expectedDistance);
        }
        int accumulatedPosition = testCar.getCurrentPosition();
        assertEquals(5 , accumulatedPosition);
    }

    @Test
    @DisplayName("우승자 처리를 위치값이 가장 높은 자동차로 처리 했는지 확인.")
    void testWinnerProcessingForHighestPosition() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(1);
        car2.move(3);
        List<Car> testCars = Arrays.asList(car1, car2);
        DetermineWinner determineWinner = new DetermineWinner();
        List<Car> winners = determineWinner.getWinners(testCars);
        assertTrue(winners.contains(car2));
    }

    @Test
    @DisplayName("우승자 처리에서 위치값이 가장 높은 자동차가 두대 이상일때 공동우승 처리가 제대로 되는지 확인")
    void testJointWinnersProcessing() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(3);
        car2.move(3);
        List<Car> testCars = Arrays.asList(car1, car2);
        DetermineWinner determineWinner = new DetermineWinner();
        List<Car> winners = determineWinner.getWinners(testCars);
        assertTrue(winners.contains(car1));
        assertTrue(winners.contains(car2));
    }
}
