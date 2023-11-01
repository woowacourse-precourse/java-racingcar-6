package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성을 테스트 하는 코드")
    void testGenerateCars() {
        String[] carNames = {"car1", "car2", "car3"};
        Cars cars = Cars.generateCars(carNames);
        List<String> names = cars.getName();
        List<Integer> scores = cars.getScore();
        assertNotNull(cars);
        assertEquals(3, names.size());

        for (String carName : carNames) {
            assertTrue(names.contains(carName));
            assertEquals(0, scores.get(names.indexOf(carName)));
        }
    }

    @Test
    @DisplayName("우승자 판단 메서드의 테스트 코드")
    void testGetWinner() {
        Cars cars = new Cars();
        List<Integer> scores = cars.getScore();
        cars.addCar("car1");
        cars.addCar("car2");
        cars.addCar("car3");

        scores.set(0, 10);
        scores.set(1, 5);
        scores.set(2, 10);

        List<String> winners = cars.getWinner();

        assertNotNull(winners);
        assertEquals(2, winners.size());
        assertTrue(winners.contains("car1"));
        assertTrue(winners.contains("car3"));
    }
}