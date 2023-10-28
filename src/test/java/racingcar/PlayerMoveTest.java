package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlayerMoveTest {
    Player testPlayer = Player.from("test");

    @Test
    void from은_플레이어를_받아_초기환된_Distance를_가지는_PlayerMove_객체를_생성한다() {
        PlayerMove playerMove = PlayerMove.from(testPlayer);
        Distance initDistance = Distance.from(0);
        assertEquals(playerMove, PlayerMove.from(testPlayer, initDistance));
    }
}
