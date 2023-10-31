package racingcar.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void validateName() {
        List<String> validNames = List.of("abcdef");
        Name name = new Name();
        assertThatThrownBy(() -> name.isValid(validNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}