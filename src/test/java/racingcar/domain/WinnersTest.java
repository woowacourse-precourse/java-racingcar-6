package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {
    @DisplayName("car1, car2가 우승해 우승자 이름이 일치하는지 확인")
    @Test
    void 우승자_이름_테스트() {
        Car car1 = Car.createCar("car1");
        Car car2 = Car.createCar("car2");
        car1.move(() -> true);
        car2.move(() -> true);
        Cars cars = Cars.from(Arrays.asList(car1.getName(), car2.getName()));
        Winners winners = Winners.from(cars);

        String winnerName = winners.getWinnerName();

        assertEquals("Car1", "Car2", winnerName);
    }
}