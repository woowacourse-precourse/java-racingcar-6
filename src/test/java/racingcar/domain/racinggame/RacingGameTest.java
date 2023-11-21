package racingcar.domain.racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.move.Move;
import racingcar.domain.move.MovePicker;
import racingcar.domain.round.Round;
import racingcar.fixed.FixedMovePicker;

final class RacingGameTest {

    @DisplayName("한번도 play 하지 않은 RacingGame은 실행 상태")
    @Test
    void racingGame_isPlaying_beforeCallingPlay() {
        // given
        final Cars cars = Cars.from("a,b,c");
        final Round maxRound = Round.from("3");
        final MovePicker movePicker = new FixedMovePicker(Move.FORWARD);
        final RacingGame racingGame = new RacingGame(cars, maxRound, movePicker);

        // when
        final boolean playing = racingGame.isPlaying();
//        racingGame.play();

        // then
        assertThat(playing).isTrue();
    }

    @DisplayName("maxRound 만큼 play 호출한 RacingGame은 실행 상태가 아님")
    @Test
    void racingGame_isNotPlaying_afterCallingMaxRoundTimes() {
        // given
        final Cars cars = Cars.from("a,b,c");
        final Round maxRound = Round.from("3");
        final MovePicker movePicker = new FixedMovePicker(Move.FORWARD);
        final RacingGame racingGame = new RacingGame(cars, maxRound, movePicker);

        // when
        racingGame.play();
        racingGame.play();
        racingGame.play();

        final boolean playing = racingGame.isPlaying();

        // then
        assertThat(playing).isFalse();
    }
}