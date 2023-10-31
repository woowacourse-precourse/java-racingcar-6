package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void determineWinner() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        car1.move();
        car2.move();

        List<Car> cars = Arrays.asList(car1, car2);

        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println(winners);
    }

    @Test
    void printWinners() {
        List<String> winners = Arrays.asList("car1","car2");
        String winnersString = String.join(", ", winners);
        Assertions.assertThat(winnersString).isEqualTo("car1, car2");
    }
}