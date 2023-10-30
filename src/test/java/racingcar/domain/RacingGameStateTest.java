package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.IllegalStateExceptionType;

class RacingGameStateTest {

    Car fakeCar1, fakeCar2;
    List<Car> rawCars;
    RacingGameState playingRacingGameState, endedRacingGameState;

    @BeforeEach
    void setUp() {
        fakeCar1 = new FakeCar("붕붕카", 1);
        fakeCar2 = new FakeCar("차차차", 0);
        rawCars = List.of(fakeCar1, fakeCar2);

        playingRacingGameState = new RacingGameState(false, rawCars);
        endedRacingGameState = new RacingGameState(true, rawCars);
    }

    @Test
    void 완료_게임_진행_상태_조회_테스트() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(endedRacingGameState.isEnd()).isEqualTo(true);
        softAssertions.assertThat(endedRacingGameState.getCarDistanceByIndex(0)).isEqualTo(fakeCar1.getDistance());
        softAssertions.assertThat(endedRacingGameState.getCarDistanceByIndex(1)).isEqualTo(fakeCar2.getDistance());
        softAssertions.assertThat(endedRacingGameState.getCarNameByIndex(0)).isEqualTo(fakeCar1.getName());
        softAssertions.assertThat(endedRacingGameState.getCarNameByIndex(1)).isEqualTo(fakeCar2.getName());
        softAssertions.assertThat(endedRacingGameState.getWinnersName()).containsOnly(fakeCar1.getName());
        softAssertions.assertAll();
    }

    @Test
    void 진행중_게임_승자_조회_실패_테스트() {
        IllegalStateException gameNotEndedException = IllegalStateExceptionType.GAME_NOT_ENDED_MESSAGE
                .getException();

        assertThat(playingRacingGameState.isEnd()).isEqualTo(false);
        assertThatThrownBy(playingRacingGameState::getWinnersName)
                .isInstanceOf(gameNotEndedException.getClass())
                .hasMessage(gameNotEndedException.getMessage());
    }
}