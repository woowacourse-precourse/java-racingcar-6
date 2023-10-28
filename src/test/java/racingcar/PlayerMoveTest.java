package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerMoveTest {

    Player testPlayer = Player.from("test");
    Distance initDistance = Distance.from(0);

    @Test
    void init은_플레이어를_받아_초기환된_Distance를_가지는_PlayerMove_객체를_생성한다() {
        PlayerMove playerMove = PlayerMove.init(testPlayer);
        assertEquals(playerMove, PlayerMove.init(testPlayer, initDistance));
    }

    @ParameterizedTest
    @CsvSource(value = {"true, 1", "false, 0"})
    void move는_이동여부에_따라_이동거리를_증가시킨다(boolean isMove, int distance) {
        // given
        PlayerMove playerMove = PlayerMove.init(testPlayer, initDistance);

        // when
        playerMove.move(isMove);

        // then
        assertEquals(distance, playerMove.getDistance().getValue());
    }
}
