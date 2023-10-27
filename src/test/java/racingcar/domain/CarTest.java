package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차의 이름이 영문(대소문자)이 아니라면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"name1", "na me", "dfd12", "123", "[.;z`", "a1ad"})
    void create_car_withInvalidName(String invalidName) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Car.of(invalidName, 0))
                .withMessageContaining("자동차 이름은 영문으로만 구성되어야 합니다.");
    }

    @DisplayName("자동차의 이름은 5글자를 넘길 수 없습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"longname", "namename", "nameanmeasdf"})
    void create_car_withOverLengthName(String overLengthName) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Car.of(overLengthName, 0))
                .withMessageContaining("자동차 이름의 길이는 5글자를 넘길 수 없습니다.");
    }

}