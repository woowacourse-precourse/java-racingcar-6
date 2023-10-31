package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player player = new Player("test");

    @DisplayName("자동차 이름 설정에 대한 테스트")
    @Test
    void 자동차_이름() {
        assertEquals("test", player.getCarName());
    }

    @DisplayName("자동차 완주 횟수에 대한 테스트")
    @Test
    void 완주_결과() {
        player.setDistance(3);
        assertEquals("test : ---", player.toString());
    }
}
