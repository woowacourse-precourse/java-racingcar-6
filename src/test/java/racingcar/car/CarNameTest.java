package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @DisplayName("유효하지 않은 차량 이름을 입력했을 때, 정확한 예외 메시지를 출력하는지 확인합니다.")
    @ParameterizedTest(name = "{0}, 이름은 1글자부터 5글자까지 가능합니다.")
    @ValueSource(strings = {"", "abcdef"})
    void constructor_WithInvalidInput_ThrowsException(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1글자부터 5글자까지 가능합니다.");
    }
}