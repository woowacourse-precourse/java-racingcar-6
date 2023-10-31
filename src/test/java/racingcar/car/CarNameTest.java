package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @Test
    void 이름을_생성한다() {
        // given
        CarName carA = new CarName("carA");

        // then
        assertThat(carA).isEqualTo(new CarName("carA"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void 이름이_잘못되면_예외가_발생한다(String carName) {
        // when
        assertThrows(IllegalArgumentException.class, () ->
                new CarName(carName));
    }
}
