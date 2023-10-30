package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Player;

class PlayerTest {

    @DisplayName("정상 이름 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "p", "pl", "pla", "play", "playa"})
    void normal_test(String input) {
        assertDoesNotThrow(() -> new Player(input));
    }

    @Test
    @DisplayName("6글자 예외 처리 테스트")
    void exception_test() {
        assertThrows(IllegalArgumentException.class, () -> new Player("player"));
    }

}