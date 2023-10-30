package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {

    @Test
    void 자동차_이름이_5자_초과일_경우_예외를_발생한다() {
        // given
        String carName = "5자 초과하는 자동차 이름";

        // when, then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "자동차 이름: {0}")
    @ValueSource(strings = {"1", "자동차1", "자동차", "pobi", "crong", "woni"})
    void 자동차_이름이_5자_이하일_경우_예외를_발생하지_않는다(String carName) {
        // when, then
        assertThatNoException().isThrownBy(() -> new CarName(carName));
    }

}
