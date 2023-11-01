package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {
    @DisplayName("0 이하 혹은 15 초과인 정수를 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10, 16, 20})
    void InputFailTest(int minInput) {
        Assertions.assertThatThrownBy(() -> new TryCount(minInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 이상 그리고 15 이하의 정수를 입력하면 TryCount 인스턴스를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 15})
    void InputPassTest(int input) {
        Assertions.assertThatNoException().isThrownBy(() -> new TryCount(input));
    }
}
