package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.Name;

public class CarNameTest {
    @Test
    void 이름_자리수_초과_예외_처리() {
        assertThatThrownBy(() -> {
            Name name = new Name("123456");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_이름_예외_처리() {
        assertThatThrownBy(() -> {
            Name name = new Name("");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_쉼표로_구분되었는지() {
        assertThatThrownBy(() -> {
            Cars cars = new Cars("a.b.c");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_두개_이상_받았는지() {
        assertThatThrownBy(() -> {
            Cars cars = new Cars(",");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

}
