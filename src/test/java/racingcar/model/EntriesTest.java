package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EntriesTest {

    @DisplayName("중복 이름 테스트")
    @Test
    void duplicate_name() {
        assertThatThrownBy(() -> new Entries(List.of("a", "a"))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈칸 이름 테스트")
    @Test
    void blank_name() {
        assertThatThrownBy(() -> new Entries(List.of(" ", " a "))).isInstanceOf(IllegalArgumentException.class);
    }
}
