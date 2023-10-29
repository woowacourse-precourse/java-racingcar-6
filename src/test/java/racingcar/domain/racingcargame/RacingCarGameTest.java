package racingcar.domain.racingcargame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.domain.attempt.Attempt;
import racingcar.domain.cars.Players;
import racingcar.domain.cars.Winners;

class RacingCarGameTest {

    @Test
    @DisplayName("Players와 Attempt로 생성할 수 있다.")
    void canConstructByPlayersAndAttempt() {
        // given
        List<String> names = Arrays.asList("tae", "wan");
        Players players = new Players(names);
        int attemptValue = 3;
        Attempt attempt = new Attempt(attemptValue);

        // when
        RacingCarGame racingCarGame = new RacingCarGame(players, attempt);

        // then
        assertThat(racingCarGame).isExactlyInstanceOf(RacingCarGame.class);
    }

    @Test
    @DisplayName("race() 호출 시 참가자들이 레이스를 진행 하고, 시도를 1회 사용한다.")
    void playersMoveAndUseAttempt_whenRace() {
        // given
        Players players = mock(Players.class);
        Attempt attempt = mock(Attempt.class);

        when(attempt.hasNext()).thenReturn(true);

        RacingCarGame racingCarGame = new RacingCarGame(players, attempt);

        // when
        racingCarGame.race();

        // then
        verify(players, times(1)).moveAll();
        verify(attempt, times(1)).use();
    }

    @Test
    @DisplayName("race() 시 남은 시도 횟수가 없으면 IllegarArgumentException을 발생한다.")
    void throwsIllegalArgumentException_whenNoAttemptRemainAtRace() {
        // given
        final String ERROR_MESSAGE_CANNOT_RACE = "더 이상 게임을 진행할 수 없습니다.";

        List<String> names = Arrays.asList("tae", "wan");
        Players players = new Players(names);
        int attemptValue = 1;
        Attempt attempt = new Attempt(attemptValue);

        RacingCarGame racingCarGame = new RacingCarGame(players, attempt);

        racingCarGame.race();

        // when, then
        assertThatThrownBy(() -> racingCarGame.race())
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE_CANNOT_RACE);
    }

    @Test
    @DisplayName("hasNext() 는 경기가 진행 가능한 상태라면 true를 반환한다.")
    void hasNextReturnTrue_whenRaceCanExecute() {
        // given
        List<String> names = Arrays.asList("tae", "wan");
        Players players = new Players(names);
        int attemptValue = 3;
        Attempt attempt = new Attempt(attemptValue);

        RacingCarGame racingCarGame = new RacingCarGame(players, attempt);

        // when
        boolean result = racingCarGame.hasNext();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("winners() 가 우승자들에 대한 정보를 반환한다.")
    void winnersReturnListOfWinningCars() {
        // given
        Players players = mock(Players.class);
        Attempt attempt = mock(Attempt.class);
        MockedStatic<Winners> mockStatic = mockStatic(Winners.class);

        RacingCarGame racingCarGame = new RacingCarGame(players, attempt);

        // when
        racingCarGame.winners();

        // then
        mockStatic.verify(() -> Winners.judge(any(Players.class)));
    }
}