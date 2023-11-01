package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.IllegalStateExceptionType;
import racingcar.domain.AlwaysMovingCar;
import racingcar.domain.Car;
import racingcar.domain.NeverMovingCar;
import racingcar.domain.RacingGameState;

class OutputViewTest {
    PrintStream standardOut;
    OutputStream captor;
    Car alwaysMovingCar, neverMovingCar;
    List<Car> rawCars;
    RacingGameState playingRacingGameState, endedRacingGameState;
    OutputView outputView = new OutputView();

    @BeforeEach
    void setUp() {
        alwaysMovingCar = new AlwaysMovingCar("붕붕카");
        neverMovingCar = new NeverMovingCar("차차차");
        alwaysMovingCar.attemptToMove();

        rawCars = List.of(alwaysMovingCar, neverMovingCar);

        playingRacingGameState = new RacingGameState(false, rawCars);
        endedRacingGameState = new RacingGameState(true, rawCars);
    }

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @DisplayName("게임_상태_출력_테스트")
    @Test
    void gameStateOutputTest() {
        outputView.printGameState(playingRacingGameState);
        assertThat(output()).contains("붕붕카 : -", "차차차 :");
    }

    @DisplayName("최종_우승자_출력_성공_테스트")
    @Test
    void finalWinnerOutputSuccessTest() {
        outputView.printWinners(endedRacingGameState);
        assertThat(output()).contains("최종 우승자 : 붕붕카");
    }

    @DisplayName("최종_우승자_출력_실패_테스트")
    @Test
    void finalWinnerOutputFailTest() {
        IllegalStateException exception = IllegalStateExceptionType
                .GAME_NOT_ENDED_MESSAGE
                .getException();

        assertThatThrownBy(() -> outputView.printWinners(playingRacingGameState))
                .isInstanceOf(exception.getClass())
                .hasMessage(exception.getMessage());
    }
}
