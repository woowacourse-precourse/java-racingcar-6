package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Judgment;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JudgmentTest {

    private Judgment judgment = new Judgment();

    @Test
    void testAllSameScores() {
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        car1.setScore(3);  // 가정: setScore 메서드나 다른 방법으로 score를 설정할 수 있음
        car2.setScore(3);
        car3.setScore(3);
        List<Car> cars = Arrays.asList(car1, car2, car3);

        List<String> expectedWinners = Arrays.asList("a", "b", "c");

        List<String> actualWinners = judgment.compare(cars);

        assertEquals(expectedWinners, actualWinners);
    }

    @Test
    void testSingleWinner() {
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        car1.setScore(1);
        car2.setScore(3);
        car3.setScore(2);
        List<Car> cars = Arrays.asList(car1, car2, car3);

        List<String> expectedWinners = Arrays.asList("b");

        List<String> actualWinners = judgment.compare(cars);

        assertEquals(expectedWinners, actualWinners);
    }

    @Test
    void testMultipleWinners() {
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        car1.setScore(3);
        car2.setScore(3);
        car3.setScore(2);
        List<Car> cars = Arrays.asList(car1, car2, car3);

        List<String> expectedWinners = Arrays.asList("a", "b");

        List<String> actualWinners = judgment.compare(cars);

        assertEquals(expectedWinners, actualWinners);
    }
}
