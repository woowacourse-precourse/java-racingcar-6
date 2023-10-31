package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class NameTest {

    @Test
    void 이름_유효성_검사() {
        List<String> list = List.of("abcdef");
        Name name = new Name();
        assertThatThrownBy(() -> name.isValid(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}