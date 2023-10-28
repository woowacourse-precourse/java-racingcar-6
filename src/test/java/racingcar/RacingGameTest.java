package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    void init은_PlayerMove리스트를_받아_GameStatus를_초기화한_객체를_생성한다() {
        List<PlayerMove> playerMoves = List.of(PlayerMove.fromTest(), PlayerMove.fromTest());
        RacingGame racingGame = RacingGame.init(playerMoves);
        assertEquals(RacingGame.from(playerMoves, GameStatus.PLAYING), racingGame);
    }
}
