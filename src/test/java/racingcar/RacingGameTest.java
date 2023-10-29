package racingcar;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    MoveFactory moveFactory = new MoveFactory(numberGenerator);

    @Test
    void init은_플레이어_이동현황_리스트를_받아_GameStatus를_초기화한_객체를_생성한다() {
        List<PlayerMove> playerMoves = List.of(PlayerMove.fromTest(), PlayerMove.fromTest());
        RacingGame racingGame = RacingGame.init(playerMoves, moveFactory);

        assertNotNull(racingGame);
    }

    @Test
    void move는_모든_플레이어_이동현황에_이동여부를_적용한다() {
        // given
        PlayerMove playerMove = mock(PlayerMove.class);
        List<PlayerMove> playerMoves = List.of(playerMove, playerMove);
        RacingGame racingGame = RacingGame.init(playerMoves, moveFactory);

        // when
        racingGame.move();

        // then
        verify(playerMove, times(playerMoves.size())).move(anyBoolean());
    }
}
