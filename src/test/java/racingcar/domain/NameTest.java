package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    void createName_Successfully() {
        Name name = new Name("Alice");
        assertThat(name.value()).isEqualTo("Alice");
    }

    @Test
    void createName_WithEmptyString_ThrowsException() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 필수값입니다.");
    }

    @Test
    void createName_WithNull_ThrowsException() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 필수값입니다.");
    }

    @Test
    void createName_WithTooLongName_ThrowsException() {
        assertThatThrownBy(() -> new Name("TooLongName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }
}
