package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_생성시_이름이_NULL이면_예외_발생() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_생성시_이름의_길이가_0이면_예외_발생() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_생성시_이름의_길이가_5보다_크면_예외_발생() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_생성시_이름에_공백이_있는_경우_예외_발생() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("1 "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(" 1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}