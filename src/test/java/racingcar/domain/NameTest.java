package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

public class NameTest {

    @Test
    public void 이름의_길이가_5초과하면_예외발생() {
        // given
        final String strName = "abcdef";

        // when && then
        Assertions.assertThatThrownBy(() -> Car.create(strName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이가 초과되었습니다.");
    }

    @Test
    public void 이름은_영어와숫자만_특수문자는_에러() {
        // given
        final String strName = "1bcd@";

        // when && then
        Assertions.assertThatThrownBy(() -> Car.create(strName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 알파벳, 숫자만 가능합니다.");
    }

    @Test
    public void 이름은_영어와숫자만_공백은_에러() {
        // given
        final String strName = "1bc ";

        // when && then
        Assertions.assertThatThrownBy(() -> Car.create(strName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 알파벳, 숫자만 가능합니다.");
    }

}
