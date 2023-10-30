package racingcar.unitTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;

public class CarNameTest {

    @Test
    void should_throwException_when_LessThan5() {
        // given
        String name = "sangHyeok";
        // when & then
        Assertions.assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void should_throwException_when_isBlank() {
        // given
        String name = "";
        // when & then
        Assertions.assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void should_true_when_toStringEqualName() {
        // given
        String name = "sang";
        // when
        CarName carName = new CarName(name);
        // then
        Assertions.assertThat(carName.toString()).isEqualTo(name);
    }
}
