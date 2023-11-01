package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ExceptionMessage.CAR_NAME_CANNOT_EXCEED_MAX_LENGTH;
import static racingcar.exception.ExceptionMessage.INPUT_IS_BLANK;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void create_메서드로_자동차_생성시_이름이_5자_초과면_예외_발생() {
        String name = "나는자동차다";

        assertThatThrownBy(() -> Car.create(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_CANNOT_EXCEED_MAX_LENGTH);
    }

    @Test
    void create_메서드로_자동차_생성시_이름이_공백이면_예외_발생() {
        String name = " ";

        assertThatThrownBy(() -> Car.create(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_IS_BLANK);
    }
}
