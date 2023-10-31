package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("성공 : 차량객체 생성")
    public void 차량객체_생성() {
        String input = "test";

        final Car car = new Car(input);

        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("성공 : 차량객체_생성_후_이름확인")
    public void 차량객체_생성_후_이름확인() {
        String input = "test";

        final Car car = new Car(input);

        assertThat(car.getName()).isEqualTo(input);
    }
}