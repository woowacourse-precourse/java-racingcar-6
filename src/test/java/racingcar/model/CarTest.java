package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ValueSource(strings = {"abcde", "엘링홀란드", "12345"})
    @ParameterizedTest
    void 차량_이름_유효성검사_테스트(String name) {

        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
