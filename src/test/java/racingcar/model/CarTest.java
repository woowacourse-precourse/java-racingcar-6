package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 객체에 대해")
class CarTest {

    @Test
    @DisplayName("이름 길이가 5 이하가 아니라면 에러가 발생한다.")
    void validate_name_length() {
        assertThatThrownBy(() -> new Car("박준수1222"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
