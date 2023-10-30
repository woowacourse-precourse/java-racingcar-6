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
    void 정상_값_테스트(String input) {
        assertDoesNotThrow(() -> new Player(input));
    }

    @Test
    void 오류_6글자_이상_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player("player"));
    }

}