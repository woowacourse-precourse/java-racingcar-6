package racingcar;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    MoveFactory moveFactory = new MoveFactory(numberGenerator);
    List<PlayerMove> playerMoves = List.of(PlayerMove.fromTest(), PlayerMove.fromTest());

    @Test
    void init은_플레이어_이동현황_리스트를_받아_GameStatus를_초기화한_객체를_생성한다() {
        PlayerMoveList playerMoveList = PlayerMoveList.from(playerMoves, moveFactory);
        RacingGame racingGame = RacingGame.init(playerMoveList);

        assertNotNull(racingGame);
    }

    @Test
    void move는_모든_플레이어_이동현황에_이동여부를_적용하도록_호출한다() {
        // given
        PlayerMoveList playerMoveList = mock(PlayerMoveList.class);
        RacingGame racingGame = RacingGame.init(playerMoveList);

        // when
        racingGame.move();

        // then
        verify(playerMoveList).move();
    }
}
