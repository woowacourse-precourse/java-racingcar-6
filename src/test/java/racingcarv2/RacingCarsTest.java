package racingcarv2;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class RacingCarsTest {
    @Test
    void RacingCars_생성() {
        RacingCars racingCars = new RacingCars(Arrays.asList(
                new Car("pobi", 3),
                new Car("hon", 1),
                new Car("li", 0)
        ));

        Assertions.assertThat(racingCars.getRacingCars()).containsExactly(
                new Car("pobi", 3),
                new Car("hon", 1),
                new Car("li", 0)
        );
    }
}
