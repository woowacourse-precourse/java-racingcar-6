package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"o", "one", "melon"})
    void 자동차이름을_입력받아_객체를_생성한다(String value) {
        CarName carName = CarName.from(value);

        assertThat(carName.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"gmelon", "gmelons"})
    void 생성_시_자동차이름이_공백이거나_5자를_넘어가면_예외가_발생한다(String value) {
        assertThatThrownBy(() -> CarName.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
