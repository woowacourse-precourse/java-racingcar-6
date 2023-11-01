package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.IllegalStateExceptionType;

class RacingGameStateTest {

    Car alwaysMovingCar, neverMovingCar;
    List<Car> rawCars;
    RacingGameState playingRacingGameState, endedRacingGameState;

    @BeforeEach
    void setUp() {
        alwaysMovingCar = new AlwaysMovingCar("붕붕카");
        neverMovingCar = new NeverMovingCar("차차차");
        alwaysMovingCar.attemptToMove();

        rawCars = List.of(alwaysMovingCar, neverMovingCar);

        playingRacingGameState = new RacingGameState(false, rawCars);
        endedRacingGameState = new RacingGameState(true, rawCars);
    }

    @DisplayName("완료_게임_진행_상태_조회_테스트")
    @Test
    void endedGameStateCheckTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(endedRacingGameState.isEnd()).isEqualTo(true);
        softAssertions.assertThat(endedRacingGameState.getCarDistanceByIndex(0)).isEqualTo(alwaysMovingCar.getDistance());
        softAssertions.assertThat(endedRacingGameState.getCarDistanceByIndex(1)).isEqualTo(neverMovingCar.getDistance());
        softAssertions.assertThat(endedRacingGameState.getCarNameByIndex(0)).isEqualTo(alwaysMovingCar.getName());
        softAssertions.assertThat(endedRacingGameState.getCarNameByIndex(1)).isEqualTo(neverMovingCar.getName());
        softAssertions.assertThat(endedRacingGameState.getWinnersName()).containsOnly(alwaysMovingCar.getName());
        softAssertions.assertAll();
    }

    @DisplayName("진행중_게임_승자_조회_실패_테스트")
    @Test
    void playingGamesWinnerCheckFailTest() {
        IllegalStateException gameNotEndedException = IllegalStateExceptionType.GAME_NOT_ENDED_MESSAGE
                .getException();

        assertThat(playingRacingGameState.isEnd()).isEqualTo(false);
        assertThatThrownBy(playingRacingGameState::getWinnersName)
                .isInstanceOf(gameNotEndedException.getClass())
                .hasMessage(gameNotEndedException.getMessage());
    }
}