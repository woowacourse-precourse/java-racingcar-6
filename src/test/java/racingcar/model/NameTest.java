package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    void name_공백이_입력됐을_경우_테스트() {
        final String inputRacingCarNames = "ab ";
        Assertions.assertThatThrownBy(() -> new RacingCar(inputRacingCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    void name_길이가_5보다_클_때_테스트() {
        final String inputRacingCarNames = "abcdef";
        Assertions.assertThatThrownBy(() -> new RacingCar(inputRacingCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    void 이름이_중복된_경우_테스트() {
        String nameList = "a,a,b";
        Assertions.assertThatThrownBy(() -> new RacingCars(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 있습니다.");
    }
}