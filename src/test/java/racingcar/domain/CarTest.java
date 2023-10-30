package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"다섯글자초과", "123456"})
    @DisplayName("자동차 이름 5글자 초과 예외 테스트")
    void carNameMaxLengthFailTest(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }
}