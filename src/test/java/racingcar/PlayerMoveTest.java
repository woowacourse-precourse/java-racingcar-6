package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlayerMoveTest {

    Player testPlayer = Player.from("test");
    Distance initDistance = Distance.from(0);

    @Test
    void init은_플레이어를_받아_초기환된_Distance를_가지는_PlayerMove_객체를_생성한다() {
        PlayerMove playerMove = PlayerMove.init(testPlayer);
        assertEquals(playerMove, PlayerMove.init(testPlayer, initDistance));
    }

    @Test
    void move는_이동여부에따라_이동거리를_증가시킨다() {
        // given
        PlayerMove playerMove = PlayerMove.init(testPlayer, initDistance);

        // when
        playerMove.move(true);

        // then
        assertEquals(1, playerMove.getDistance().getValue());
    }
}
