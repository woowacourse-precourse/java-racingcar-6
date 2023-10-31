package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @ParameterizedTest(name = "{index}번째 자동차 이름: {0}")
    @ValueSource(strings = {"1", "자동차1", "자동차", "pobi", "crong", "woni"})
    void 자동차_이름이_5자_이하일_경우_예외를_발생하지_않는다(String carName) {
        // when, then
        assertThatNoException().isThrownBy(() -> new CarName(carName));
    }

    @ParameterizedTest(name = "{index}번째 자동차 이름: \"{arguments}\"")
    @ValueSource(strings = {"", " ", "  ","    "})
    void 자동차_이름이_공백일_경우_예외를_발생한다(String carName) {
        // when, then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_공백이_아닌_경우_예외를_발생하지_않는다() {
        // given
        final String carName = "자 동 차";
        // when, then
        assertThatNoException().isThrownBy(() -> new CarName(carName));
    }

    @Test
    void 자동차_이름이_같다면_동등성을_보장한다() {
        // given, when
        CarName carName1 = new CarName("자동차1");
        CarName carName2 = new CarName("자동차1");

        // then
        assertAll(
                () -> assertThat(carName1).isEqualTo(carName2),
                () -> assertThat(carName1).hasSameHashCodeAs(carName2)
        );
    }

    @Test
    void 자동차_이름이_다르면_동등성을_보장하지_않는다() {
        // given, when
        CarName carName1 = new CarName("자동차1");
        CarName carName2 = new CarName("자동차2");

        // then
        assertAll(
                () -> assertThat(carName1).isNotEqualTo(carName2),
                () -> assertThat(carName1).doesNotHaveSameHashCodeAs(carName2)
        );
    }

}