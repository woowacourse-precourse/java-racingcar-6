package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingTest {
    @Test
    void Racing_초기화() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1"));
        Racing racing = new Racing(cars, 5, 4);

        assertNotNull(racing);
        assertEquals(cars, racing.getCars());
        assertEquals(Integer.valueOf(5), racing.getIterNum());
        assertEquals(3, racing.getThreshold());
    }
}
