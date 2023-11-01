package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import racingcar.model.enums.SpecialSign;

class SpecialSignTest {

    @DisplayName("Enum 인자를 확인한다.")
    @ParameterizedTest
    @EnumSource(value = SpecialSign.class)
    void testEnumSourceValue(SpecialSign specialSign) {
    }

    @DisplayName("값이 스페이스만 확인한다.")
    @ParameterizedTest
    @EnumSource(mode = Mode.INCLUDE, names = {"SPACE"})
    void testSpaceValueTest(SpecialSign specialSign) {
        assertThat(specialSign.getSign()).isEqualTo(" ");
    }
}