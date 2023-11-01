package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {

    @DisplayName("자동차의 Position이 가장 크면 우승자이다.")
    @Test
    void getMaxPosition() {
        List<Car> carList = List.of(new Car("test1"), new Car("test2"), new Car("test3"));

        int maxPosition = 0;
        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        assertEquals(0, maxPosition);
    }

    @DisplayName("우승자의 이름은 쉼표(,)를 기준으로 구분되어 출력된다.")
    @Test
    void getWinners() {
        List<Car> carList = List.of(new Car("test1"), new Car("test2"), new Car("test3"));

        StringBuilder winner = new StringBuilder();
        for (Car car : carList) {
            if (car.getPosition() == 0) {
                winner.append(car.getName()).append(", ");
            }
        }

        assertEquals("test1, test2, test3", winner.substring(0, winner.length() - 2));
    }
}