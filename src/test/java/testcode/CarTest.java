package testcode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

class CarTest {

    @Test
    public void 자동차_생성() {
        String name = "jack,bob";

        Car car = new Car(name);

        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"jack,jack", "123456", "jack"})
    public void 자동차_생성_실패(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }


}
