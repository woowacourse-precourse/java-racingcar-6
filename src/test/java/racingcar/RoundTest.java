package racingcar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundTest {

    @Test
    @DisplayName("진행 테스트")
    public void roundTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));

        for (Car player : cars) {
            player.move();
            assertTrue(player.getCount() > 0);
        }
    }
}
