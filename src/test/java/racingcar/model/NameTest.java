package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NameTest {
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


}
