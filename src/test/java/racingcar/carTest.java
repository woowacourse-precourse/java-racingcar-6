package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

class carTest {
    @Test
    public void 자동차_생성() {
        // given
        String name = "pobi";
        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456", " "})
    public void 자동차_생성_실패(String name) {
        // then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
