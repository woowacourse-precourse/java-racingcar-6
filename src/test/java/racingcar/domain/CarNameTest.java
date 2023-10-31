package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "cobi"})
    @DisplayName("경주할 자동차를 생성할 수 있다.")
    void test_name_constructor_success(String input) {
        // when
        CarName carName = new CarName(input);

        // then
        assertThat(carName.name()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"","avante", "sonata"})
    @DisplayName("경주할 자동차 이름은 유효한 범위(1이상 5이하)를 가져야한다. ")
    void test_name_constructor_fail_over_length_name(String carName) {
        // given
        String expectedMessage = "자동차이름은 1자리이상 5자 이하만 가능합니다.";

        // when & then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}