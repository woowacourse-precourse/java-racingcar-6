package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class WinnerCheckerTest {

    @DisplayName("findWinner(): 1등 List<Car>를 찾는 기능")
    @Test
    void testFindWinner() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("붕붕이");
        Car car2 = new Car("부릉이");
        Car car3 = new Car("부와앙");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.get(1).move();
        carList.get(1).move();

        assertEquals(WinnerChecker.findWinner(carList).get(0).getNameToString(), "부릉이");
    }

    @DisplayName("다중 우승자")
    @Test
    void testMultipleWinner() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("트럭");
        Car car2 = new Car("버스");
        Car car3 = new Car("고장난차");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.get(1).move();
        carList.get(0).move();

        assertThat(WinnerChecker.findWinner(carList).stream()
                .map(Car::getNameToString)
                .toList())
                .contains("트럭", "버스");
    }
}
