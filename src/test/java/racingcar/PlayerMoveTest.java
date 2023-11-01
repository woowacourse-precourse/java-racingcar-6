package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Distance;
import racingcar.domain.Player;
import racingcar.domain.PlayerMove;

public class PlayerMoveTest {

    Player testPlayer = Player.from("test");

    @Test
    void init은_플레이어를_받아_초기화된_거리를_가지는_PlayerMove_객체를_생성한다() {
        PlayerMove playerMove = PlayerMove.init(testPlayer);
        assertEquals(playerMove, PlayerMove.of(testPlayer, Distance.from(0)));
    }

    @Test
    void of는_플레이어와_거리를_받아_PlayerMove_객체를_생성한다() {
        PlayerMove playerMove = PlayerMove.of(testPlayer, Distance.from(3));
        assertNotNull(playerMove);
    }

    @ParameterizedTest
    @CsvSource(value = {"true, 2", "false, 1"})
    void move는_이동여부에_따라_이동거리를_증가시킨다(boolean isMove, int distance) {
        // given
        PlayerMove playerMove = PlayerMove.of(testPlayer, Distance.from(1));

        // when
        playerMove.move(isMove);

        // then
        assertEquals(distance, playerMove.getDistance().getValue());
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 0, 1", "0, 1, 1", "1, 1, 1"})
    void getMaxDistance는_게임의_거리_최댓값과_자신의_거리를_비교하여_최댓값을_반환한다(int maxValue, int myValue, int resultValue) {
        PlayerMove playerMove = PlayerMove.of(testPlayer, Distance.from(myValue));
        assertThat(playerMove.getMaxDistance(maxValue)).isEqualTo(resultValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 0", "2, 1", "3, 3"})
    void checkWinner_플레이어의_거리값이_게임의_최대값과_동일하거나_클때_우승자체크를_실행한다(int myValue, int maxValue) {
        // given
        Player player = mock(Player.class);
        PlayerMove playerMove = PlayerMove.of(player, Distance.from(myValue));

        // when
        playerMove.checkWinner(maxValue);

        // then
        verify(player).checkWinner();
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 2"})
    void checkWinner_플레이어의_거리값이_게임의_최대값보다_작을때_우승자체크를_실행하지_않는다(int myValue, int maxValue) {
        // given
        Player player = mock(Player.class);
        PlayerMove playerMove = PlayerMove.of(player, Distance.from(myValue));

        // when
        playerMove.checkWinner(maxValue);

        // then
        verify(player, never()).checkWinner();
    }
}
