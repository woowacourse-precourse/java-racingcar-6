package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameManagerTest {
    GameManager gameManager = new GameManager();

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 자동차_등록_기능_확인() {
        List<String> inputs = Arrays.asList("aaa", "bb", "c", "DddD");
        gameManager.set(inputs, 1);
        gameManager.play();
        assertThat(outputStreamCaptor.toString()).contains("aaa : ", "bb : ", "c : ", "DddD : ");
    }
}
