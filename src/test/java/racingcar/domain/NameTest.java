package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    
    @Test
    @DisplayName("이름 길이가 5가 넘어갈 경우 예외 발생")
    void validateNameLength() {
        String name = "abcdef";

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 같을 경우 true를 반환한다.")
    void equalsTest() {
        String name = "ab";
        Name name1 = new Name(name);
        Name name2 = new Name(name);
        assertThat(name1.equals(name2)).isTrue();
    }
}
