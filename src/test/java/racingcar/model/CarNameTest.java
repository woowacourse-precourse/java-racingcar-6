package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 자동차_이름은_공백이_될_수_없다(String carName) {
        assertThatThrownBy(() -> CarName.from(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"sochan", "sochan ", " sochan"})
    void 자동차_이름은_허용가능한_길이를_벗어나면_안된다(String carName) {
        assertThatThrownBy(() -> CarName.from(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "a"})
    void 자동차_이름은_공백이_아니고_허용가능한_길이를_가져야한다(String carName) {
        assertDoesNotThrow(() -> CarName.from(carName));
    }

    @Test
    void 자동차_이름이_서로_같다면_같은_객체로_판단한다() {
        CarName actualCarName = CarName.from("jack");
        CarName expectedCarName = CarName.from("jack");

        assertThat(actualCarName).isEqualTo(expectedCarName);
    }
}
