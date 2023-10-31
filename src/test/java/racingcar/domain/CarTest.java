package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void 자동차_이름이_5글자보다_짧으면_정상적으로_실행된다() {
        assertThatCode(() -> {
            new Car("short");
        }).doesNotThrowAnyException();
    }

    @Test
    public void 자동차_이름이_5글자보다_길면_예외를_던진다() {
        String longName = "longName";

        assertThatThrownBy(() -> {
            new Car(longName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}