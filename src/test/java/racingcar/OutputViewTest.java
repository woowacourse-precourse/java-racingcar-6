package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;
import racingcar.view.OutputView;

public class OutputViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private OutputView outputView;

    List<Player> playerList = new ArrayList<>();



    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outContent));

        playerList = List.of(
                new Player("aaa", 1),
                new Player("ccc", 1)
        );
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 중간_결과_출력_확인() {
        outputView.printPartialResults(playerList);

        // Capture the console output
        String consoleOutput = outContent.toString().trim();

        // Assert the console output matches the expected result
        assertThat(consoleOutput).contains("aaa : -", "ccc : -");
    }


    @Test
    void 최종_결과_출력_확인() {
        outputView.printFinalResults(playerList);

        // Capture the console output
        String consoleOutput = outContent.toString().trim();

        // Assert the console output matches the expected result
        assertThat(consoleOutput).contains("최종 우승자 : aaa, ccc");
    }
}
