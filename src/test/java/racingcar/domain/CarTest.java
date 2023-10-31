package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("Car 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"lion"})
    void CarTest(String string) {
        assertThat(new Car(string)).isInstanceOf(Car.class);
    }

    @DisplayName("Car 이름이 다섯 글자를 초과할 때")
    @ParameterizedTest
    @ValueSource(strings = {"banana"})
    void exceedMaximumStringLengthTest(String string) {
        assertThatThrownBy(() -> new Car(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름이 다섯글자를 초과했습니다.");
    }
}