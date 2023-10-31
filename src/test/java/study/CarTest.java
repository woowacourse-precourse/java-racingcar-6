package study;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "여섯글자입력"})
    void Car_객체의_이름은_1글자에서_5글자이다_예외처리(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"한", "다섯글자임"})
    void Car_객체의_이름은_1글자에서_5글자이다_성공(String name) {
        assertThatCode(() -> new Car(name));
    }
}
