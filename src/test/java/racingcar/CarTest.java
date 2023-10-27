package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

class CarTest {
    @ParameterizedTest
    @DisplayName("자동차는 이름과 위치를 가진다.")
    @CsvSource(value = {"go, 1", "kim, 2"})
    void test1(final String name, final int position) {
        Car car = new Car(name, position);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
