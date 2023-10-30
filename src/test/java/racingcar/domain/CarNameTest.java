package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("이름에 공백이 포함되면 예외가 발생해야 한다.")
    void blankCheck() {
        assertThatThrownBy(() -> new CarName("a b")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 비어있다면 예외가 발생해야 한다.")
    void noNameCheck() {
        assertThatThrownBy(() -> new CarName("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름의 길이가 5자를 초과하면 예외가 발생해야 한다.")
    void nameLengthCheck() {
        assertThatThrownBy(() -> new CarName("aaaaab")).isInstanceOf(IllegalArgumentException.class);
    }
}