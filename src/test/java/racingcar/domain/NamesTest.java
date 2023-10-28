package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NamesTest {
    
    @Test
    @DisplayName("중복되는 이름이 존재할 경우 예외 발생")
    void validateDuplicateName() {
        // given
        String name = "aa";
        List<Name> duplicateNames = List.of(new Name(name), new Name(name));
        // when, then
        assertThatThrownBy(() -> new Names(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
