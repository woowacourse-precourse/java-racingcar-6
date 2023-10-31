package Test;

import static org.assertj.core.api.Assertions.assertThat;

import Controller.RacingGame;
import View.OutputView;
import java.io.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProgressTest {
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 정상_진행() {
        RacingGame racingGame = new RacingGame();
        String nameInput = "test1,test2\n";
        String trialInput = "5";
        InputStream in = createInputStream(nameInput, trialInput);
        System.setIn(in);
        racingGame.gameInit();
        assertThat(outputStream.toString())
                .contains(OutputView.getMessage("RESULT"), OutputView.getMessage("WINNER"));
    }

    private InputStream createInputStream(String nameInput, String trial) {
        return new SequenceInputStream(
                new ByteArrayInputStream(nameInput.getBytes()),
                new ByteArrayInputStream(trial.getBytes()));
    }
}
