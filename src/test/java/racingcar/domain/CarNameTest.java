package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"apple12"})
    void 잘못된_데이터가_들어오면_예외_발생(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성_5_이하의_길이가_들어오면_성공() {
        assertDoesNotThrow(() -> new CarName("apple"));
    }
}