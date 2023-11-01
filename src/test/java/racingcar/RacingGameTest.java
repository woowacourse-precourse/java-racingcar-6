package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Distance;
import racingcar.domain.MoveFactory;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Player;
import racingcar.domain.PlayerMove;
import racingcar.domain.RaceCount;
import racingcar.domain.RaceRound;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;

public class RacingGameTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    MoveFactory moveFactory = new MoveFactory(numberGenerator);
    PlayerMove playerMove = PlayerMove.from(Player.from("test"), Distance.from(1));
    List<PlayerMove> playerMoves = List.of(playerMove, playerMove);

    @Test
    void init은_플레이어_이동현황_리스트를_받아_시도횟수를_초기화한_객체를_생성한다() {
        RaceRound raceRound = RaceRound.of(playerMoves, moveFactory);

        RacingGame racingGame = RacingGame.init(raceRound);

        assertEquals(RacingGame.from(raceRound, RaceCount.init()), racingGame);
    }

    @Test
    void move는_시도횟수를_1증가시키고_모든_플레이어_이동현황에_이동여부를_적용하도록_호출한다() {
        // given
        RaceRound raceRound = mock(RaceRound.class);
        RaceCount raceCount = mock(RaceCount.class);
        RacingGame racingGame = RacingGame.from(raceRound, raceCount);

        // when
        racingGame.move();

        // then
        verify(raceRound).move();
        verify(raceCount).increase();
    }
}
