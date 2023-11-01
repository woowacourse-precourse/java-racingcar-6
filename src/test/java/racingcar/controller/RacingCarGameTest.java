package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outputStream));

    }

    @AfterEach
    public void restoreStream() {
        System.setOut(printStream);
        Console.close();
    }

    @Test
    void startRacingCarGame_참가자_1명_실행_10번() {
        String input = "test\n10";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.startRacingCarGame();

        assertThat(outputStream.toString()).contains("최종 우승자 : test");
    }

    @Test
    void startRacingCarGame_참가자_2명_실행_0번() {
        String input = "test,case\n0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.startRacingCarGame();

        assertThat(outputStream.toString()).contains("최종 우승자 : test, case");
    }

}