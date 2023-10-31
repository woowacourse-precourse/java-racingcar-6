package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {
    @Test
    void 자동차_객체를_생성한다() {
        Car car = new Car("Jason", 1);
        assertThat(car.getName()).isEqualTo("Jason");
        assertThat(car.getPosition()).isEqualTo(1);
    }
}