package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class JudgeMachineTest {
    @Test
    public void testGetWinningCars() {
        JudgeMachine judgeMachine = new JudgeMachine();
        // Car객체 3개 생성
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        // Car 객체들의 location 초기값은 0
        List<Car> winningCars = judgeMachine.getWinningCars(carList);
        // winners : car1,car2,car3

        assertEquals(3, winningCars.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(carList.get(i).getName(), winningCars.get(i).getName());
        }

        // Car객체들에 isWinner값 초기화
        for (Car car : carList) {
            car.setWinner(false);
        }

        // 이동
        car1.move(1);
        car2.move(2);
        car3.move(3); // jun 우승 예상

        winningCars = judgeMachine.getWinningCars(carList);
        assertEquals(1, winningCars.size());
        assertEquals("jun", winningCars.get(0).getName());
    }
}
