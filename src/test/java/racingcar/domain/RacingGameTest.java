package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.IllegalArgumentExceptionType;
import racingcar.constant.IllegalStateExceptionType;

class RacingGameTest {
    final int ZERO_ATTEMPT = 0;
    final int ONE_ATTEMPT = 1;

    Car alwaysMovingCar1, alwaysMovingCar2;
    List<Car> rawCars;
    Cars cars;

    @BeforeEach
    void setUp() {
        alwaysMovingCar1 = new AlwaysMovingCar("붕붕카");
        alwaysMovingCar2 = new AlwaysMovingCar("차차차");
        rawCars = List.of(alwaysMovingCar1, alwaysMovingCar2);
        cars = new Cars(rawCars);

    }

    @DisplayName("이동_횟수_최소조건_실패_테스트")
    @Test
    void minimumAttemptFailTest() {
        assertThatThrownBy(() -> new RacingGame(cars, ZERO_ATTEMPT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.ATTEMPT_COUNT_INIT_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("게임_진행_성공_테스트")
    @Test
    void proceedingGameSuccessTest() {
        RacingGame racingGame = new RacingGame(cars, ONE_ATTEMPT);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(racingGame.isEnd()).isEqualTo(false);
        softAssertions.assertThatCode(racingGame::proceed).doesNotThrowAnyException();
        softAssertions.assertThat(racingGame.isEnd()).isEqualTo(true);

        softAssertions.assertAll();
    }

    @DisplayName("게임_진행_실패_테스트")
    @Test
    void proceedingGameFailTest() {
        RacingGame racingGame = new RacingGame(cars, ONE_ATTEMPT);
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
