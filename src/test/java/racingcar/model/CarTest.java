package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 객체에 대해")
class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"박준수12222", "123456", "1234567"})
    @DisplayName("이름 길이가 5 이하가 아니라면 에러가 발생한다.")
    void validate_name_length(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
