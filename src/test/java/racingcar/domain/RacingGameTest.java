package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.IllegalArgumentExceptionType;
import racingcar.constant.IllegalStateExceptionType;

class RacingGameTest {

    private static final int ZERO_ATTEMPT = 0;
    private static final int ONE_ATTEMPT = 1;
    Car gameCar1, gameCar2;
    List<Car> rawGameCars;
    Cars gameCars;

    @BeforeEach
    void setUp() {
        gameCar1 = new GameCar("붕붕카");
        gameCar2 = new GameCar("차차차");
        rawGameCars = List.of(gameCar1, gameCar2);
        gameCars = new GameCars(rawGameCars);

    }

    @Test
    void 이동_횟수_최소조건_실패_테스트() {
        assertThatThrownBy(() -> new RacingGame(gameCars, ZERO_ATTEMPT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.ATTEMPT_COUNT_INIT_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 게임_진행_성공_테스트() {
        RacingGame racingGame = new RacingGame(gameCars, ONE_ATTEMPT);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(racingGame.isEnd()).isEqualTo(false);
        softAssertions.assertThatCode(racingGame::proceed).doesNotThrowAnyException();
        softAssertions.assertThat(racingGame.isEnd()).isEqualTo(true);

        softAssertions.assertAll();
    }
    @Test
    void 게임_진행_실패_테스트() {
        RacingGame racingGame = new RacingGame(gameCars, ONE_ATTEMPT);
        racingGame.proceed();

        IllegalStateException noMoreAttemptException = IllegalStateExceptionType
                .NO_MORE_ATTEMPT_MESSAGE
                .getException();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThatThrownBy(racingGame::proceed)
                .isInstanceOf(noMoreAttemptException.getClass())
                .hasMessage(noMoreAttemptException.getMessage());

        softAssertions.assertAll();
    }

}
