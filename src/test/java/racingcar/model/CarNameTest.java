package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    
    @Test
    void 자동차_이름이_null이라면_유효하지_않다() {
        assertThatThrownBy(() -> CarName.from(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 자동차_이름에_공백이_들어가면_유효하지_않다(String carName) {
        assertThatThrownBy(() -> CarName.from(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"crong ", " crong"})
    void 자동차_이름은_공백을_포함한_허용가능한_길이를_초과하면_유효하지_않다(String carName) {
        assertThatThrownBy(() -> CarName.from(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "crong"})
    void 자동차_이름이_허용_길이_이내면_생성된다(String carName) {
        assertDoesNotThrow(() -> CarName.from(carName));
    }

    @Test
    void 자동차_이름이_서로_같다면_같은_객체로_판단한다() {
        CarName actualCarName = CarName.from("jack");
        CarName expectedCarName = CarName.from("jack");

        assertThat(actualCarName).isEqualTo(expectedCarName);
    }

    @Test
    void 자동차_이름이_서로_다르다면_다른_객체로_판단한다() {
        CarName actualCarName = CarName.from("jack");
        CarName expectedCarName = CarName.from("crong");

        assertThat(actualCarName).isNotEqualTo(expectedCarName);
    }

    @Test
    void 동일한_자동차_이름은_동일한_hashcode를_가진다() {
        CarName actualCarName = CarName.from("jack");
        CarName expectedCarName = CarName.from("jack");

        assertThat(actualCarName.hashCode()).isEqualTo(expectedCarName.hashCode());
    }
}
