package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Distance;
import racingcar.domain.MoveFactory;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Player;
import racingcar.domain.PlayerMove;
import racingcar.domain.PlayerMoveList;
import racingcar.domain.RandomNumberGenerator;

public class PlayerMoveListTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    MoveFactory moveFactory = new MoveFactory(numberGenerator);

    @Test
    void from은_모든_플레이어의_이동현황을_받아_객체를_생성한다() {
        List<PlayerMove> playerMoves = List.of(PlayerMove.fromTest(), PlayerMove.fromTest());
        PlayerMoveList playerMoveList = PlayerMoveList.of(playerMoves, moveFactory);
        assertNotNull(playerMoveList);
    }

    @Test
        // 조금 더 자세한 테스트?
    void move는_모든_플레이어_이동현황에_이동여부를_적용한다() {
        // given
        PlayerMove playerMove = mock(PlayerMove.class);
        PlayerMoveList playerMoveList = PlayerMoveList.of(List.of(playerMove, playerMove), moveFactory);

        // when
        playerMoveList.move();

        // then
        verify(playerMove, times(playerMoveList.getPlayerMoveList().size())).move(anyBoolean());
    }

    @Test
    void getMaxDistance는_모든_플레이어_이동현황중에_가장_거리가_먼_값을_반환한다() {
        List<PlayerMove> playerMoves = List.of(
                PlayerMove.of(Player.from("a"), Distance.from(0)),
                PlayerMove.of(Player.from("b"), Distance.from(1)),
                PlayerMove.of(Player.from("c"), Distance.from(2))
        );
        PlayerMoveList playerMoveList = PlayerMoveList.of(playerMoves, moveFactory);

        assertEquals(2, playerMoveList.getMaxDistance());
    }

    @Test
    void checkWinner는_모든_플레이어_이동현황에_우승자를_체크하도록_호출한다() {
        // given
        PlayerMove playerMove = mock(PlayerMove.class);
        PlayerMoveList playerMoveList = PlayerMoveList.of(List.of(playerMove, playerMove), moveFactory);
        int max = 0;

        // when
        playerMoveList.checkWinner();

        // then
        verify(playerMove, times(playerMoveList.getPlayerMoveList().size())).checkWinner(max);
    }
}
