package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCar;
import racingcar.utils.RacingCarGame;
import racingcar.utils.RacingCarGameOutput;

public class RacingCarGameTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private RacingCarGame racingCarGame;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    private void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private String getOutputString() {
        return outputStreamCaptor.toString().trim();
    }

    @Test
    void 전진하는_조건일시_정상_작동() {
        racingCarGame = new RacingCarGame(List.of(
                new RacingCar("yang")
        ), 1);
        racingCarGame.run(() -> MOVING_FORWARD);

        assertThat(getOutputString()).isEqualTo("yang : -");
    }

    @Test
    void 전진하는_조건이_아닐_시_자동차_정차_정상_작동() {
        racingCarGame = new RacingCarGame(List.of(
                new RacingCar("yang")
        ), 1);
        racingCarGame.run(() -> STOP);

        assertThat(getOutputString()).isEqualTo("yang :");
    }

    @Test
    void 우승자가_1명일시_우승자_리스트_반환_정상_작동() {
        racingCarGame = new RacingCarGame(List.of(
                new RacingCar("yang")
        ), 1);
        List<RacingCar> winners = racingCarGame.getWinners();
        RacingCarGameOutput.printWinnersMessage(winners);

        assertThat(getOutputString()).isEqualTo("최종 우승자 : yang");
    }

    @Test
    void 우승자가_2명이상일시_우승자_리스트_반환_정상_작동() {
        racingCarGame = new RacingCarGame(List.of(
                new RacingCar("yang"),
                new RacingCar("min"),
                new RacingCar("cheol")
        ), 1);
        List<RacingCar> winners = racingCarGame.getWinners();
        RacingCarGameOutput.printWinnersMessage(winners);

        assertThat(getOutputString()).isEqualTo("최종 우승자 : yang, min, cheol");
    }
}
