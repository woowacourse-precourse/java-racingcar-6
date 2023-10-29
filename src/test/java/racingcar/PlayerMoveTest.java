package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerMoveTest {

    Player testPlayer = Player.from("test");
    Distance initDistance = Distance.from(0);

    @Test
    void init은_플레이어를_받아_초기환된_Distance를_가지는_PlayerMove_객체를_생성한다() {
        PlayerMove playerMove = PlayerMove.init(testPlayer);
        assertEquals(playerMove, PlayerMove.of(testPlayer, initDistance));
    }

    @ParameterizedTest
    @CsvSource(value = {"true, 1", "false, 0"})
    void move는_이동여부에_따라_이동거리를_증가시킨다(boolean isMove, int distance) {
        // given
        PlayerMove playerMove = PlayerMove.of(testPlayer, initDistance);

        // when
        playerMove.move(isMove);

        // then
        assertEquals(distance, playerMove.getDistance().getValue());
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 1", "2, 2"})
    void getMaxDistance는_현재의_거리_최댓값과_자신의_거리를_비교하여_결과를_반환한다(int myDistance, int resultMax) {
        int presentMax = 1;
        PlayerMove playerMove = PlayerMove.of(testPlayer, Distance.from(myDistance));
        assertThat(playerMove.getMaxDistance(presentMax)).isEqualTo(resultMax);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 0", "2, 1", "3, 3"})
    void checkWinner_플레이어의_거리값이_현재_거리의_최대값과_동일하거나_클때_우승자체크를_실행한다(int myDistance, int maxDistance) {
        // given
        Player player = mock(Player.class);
        PlayerMove playerMove = PlayerMove.of(player, Distance.from(myDistance));

        // when
        playerMove.checkWinner(maxDistance);

        // then
        verify(player).checkWinner();
    }
}
