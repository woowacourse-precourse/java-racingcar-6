package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    void 이름에_공백이_주어짐() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름에_빈칸이_주어짐() {
        assertThatThrownBy(() -> new Name(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_여섯글자_이상_주어짐() {
        assertThatThrownBy(() -> new Name("imnotcar"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
