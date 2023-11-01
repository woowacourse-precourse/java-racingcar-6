package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.Error;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"ABCDEF", ""})
    @DisplayName("유효하지 않은 자동차 이름 검증 테스트")
    void 자동차의_이름은_길이는_공백과_5자_초과를_허용하지_않는다(String carName) {
        //when & then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.CAR_NAME_LENGTH_ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"벤츠", "아우디"})
    @DisplayName("유효한 자동차 이름 검증 테스트")
    void 자동차의_이름은_1자_이상_5자_이하만_가능하다(String carName) {
        //when & then
        assertDoesNotThrow(() -> new Car(carName));
    }
}