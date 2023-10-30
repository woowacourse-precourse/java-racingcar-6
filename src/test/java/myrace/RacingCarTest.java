package myrace;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RacingCarTest {

    @Test
    void 자동차_객체를_생성한다() {
        Car car = new Car("Jason", 1);
        assertThat(car.getName()).isEqualTo("Jason");
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
