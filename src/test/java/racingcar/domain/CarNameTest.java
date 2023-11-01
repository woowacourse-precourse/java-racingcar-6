package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @DisplayName("자동차의 이름은 5글자를 넘길 수 없습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "bbbbbb", "cccccc"})
    void carName_exception_over5Letters(String invalidName) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> CarName.from(invalidName))
                .withMessageContaining("자동차 이름의 길이는 5글자를 넘길 수 없습니다.");
    }

    @DisplayName("자동차의 이름은 영문이 아니면 안됩니다.")
    @ParameterizedTest
    @ValueSource(strings = {"asd_", " sdr", "dr_sd", "sdf감", "자동차", "as as"})
    void carName_exception_invalidFormat(String invalidName) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> CarName.from(invalidName))
                .withMessageContaining("자동차 이름은 영문으로만 구성되어야 합니다.");
    }
}