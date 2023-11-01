package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GoOrStopTest {

    @Test
    public void testCarAccelerator() {
        List<String> cars = new ArrayList<>();
        cars.add("Car1");
        cars.add("Car2");

        List<String> result = GoOrStop.carAccelerator(cars);

        assertThat(result).isNotNull();

        if (result.stream().allMatch(car -> !car.contains("-"))) {
            assertThat(result).containsExactlyElementsOf(cars);
        } else {
            assertThat(result).hasSameSizeAs(cars);
        }
    }
}
