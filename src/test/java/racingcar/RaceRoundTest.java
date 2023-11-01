package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Distance;
import racingcar.domain.MoveFactory;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Player;
import racingcar.domain.PlayerMove;
import racingcar.domain.RaceRound;
import racingcar.domain.RandomNumberGenerator;

public class RaceRoundTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    MoveFactory moveFactory = new MoveFactory(numberGenerator);

    @Test
    void of는_모든_플레이어의_이동현황을_받아_객체를_생성한다() {
        PlayerMove playerMove = PlayerMove.from(Player.from("test"), Distance.from(1));

        List<PlayerMove> playerMoves = List.of(playerMove, playerMove);

        assertThat(RaceRound.of(playerMoves, moveFactory)).isInstanceOf(RaceRound.class);
    }

    @Test
    void move는_모든_플레이어_이동현황에_이동여부를_적용한다() {
        // given
        PlayerMove playerMove = mock(PlayerMove.class);
        RaceRound raceRound = RaceRound.of(List.of(playerMove, playerMove), moveFactory);

        // when
        raceRound.move();

        // then
        verify(playerMove, times(raceRound.getPlayerMoveList().size())).move(anyBoolean());
    }

    @Test
    void checkWinner는_모든_플레이어_이동현황에_우승자를_체크하도록_호출한다() {
        // given
        PlayerMove playerMove = mock(PlayerMove.class);
        RaceRound raceRound = RaceRound.of(List.of(playerMove, playerMove), moveFactory);
        int initMax = 0;

        // when
        raceRound.checkWinner();

        // then
        verify(playerMove, times(raceRound.getPlayerMoveList().size())).checkWinner(initMax);
    }

    @Test
    void getMaxDistance는_모든_플레이어_이동현황중에_최대값을_반환해_checkWinner로_해당_플레이어에게_우승자체크를_호출한다() {
        // given
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        PlayerMove playerMove1 = PlayerMove.from(player1, Distance.from(1));
        PlayerMove playerMove2 = PlayerMove.from(player2, Distance.from(2));
        RaceRound raceRound = RaceRound.of(List.of(playerMove1, playerMove2), moveFactory);

        // when
        raceRound.checkWinner();

        // then
        verify(player1, never()).checkWinner();
        verify(player2).checkWinner();
    }
}
