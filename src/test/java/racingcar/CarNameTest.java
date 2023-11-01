package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @EmptySource
    public void 이름_필수_예외테스트(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"po b i", "songyi"})
    public void 이름_길이_테스트(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이하여야 합니다.");
    }
}