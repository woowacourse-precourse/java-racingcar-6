package racingcar.validation;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.repository.Player;

class ValidationTest {

    @Test
    void playerNameValidation() {
        assertThatThrownBy(() -> {
            Player player = new Player("aaaaaa", 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}