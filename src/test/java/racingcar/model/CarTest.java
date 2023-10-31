package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    @ParameterizedTest
    @CsvSource({"test, test", "ab, ab"})
    void car_생성확인(String name, String answer) {
        Car car = new Car(name);
        String result = car.getName();

        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({"longName", ",", "' '"})
    void car_생성시_이름_길이_예외처리_확인(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_숫자증가() {
        final int NUM = 4;
        Car car = new Car("test");
        for (int i = 0; i < NUM; i++) {
            car.increaseStep();
        }
        assertThat(car.getStep()).isEqualTo(4);
    }
}