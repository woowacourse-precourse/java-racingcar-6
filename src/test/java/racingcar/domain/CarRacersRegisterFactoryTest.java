package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class CarRacersRegisterFactoryTest {

    @Test
    void 중복된_자동차_이름을_제공할_수_없다() {
        // given
        List<String> expectedRacerNames = Stream.of("one", "one", "three").toList();
        // when
        // then
        assertThatThrownBy(() -> CarRacersRegisterFactory.of(expectedRacerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Duplicate racer names: [one]");
    }
}