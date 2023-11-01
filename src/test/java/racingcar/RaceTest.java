package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

public class RaceTest {

    @Test
    void 최대_위치_찾기() {
        List<Car> cars = Arrays.asList(new Car("car1"),new Car("car2"),new Car("car3"));
        Race race = new Race(cars,1);
        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();
        int maxPosition = race.findMaxPosition();
        assertThat(maxPosition).isEqualTo(1);
    }
}
