package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void Car_객체는_이름_속성을_가짐() {
        final String expectedName = "이름";
        final Car car = new Car(expectedName);
        assertThat(car.getName()).isEqualTo(expectedName);
    }
}
