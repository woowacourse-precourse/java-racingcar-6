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

    private List<Player> playerList = new ArrayList<>();
    private List<String> winnerList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outContent));

        playerList = List.of(
                new Player("aaa", 1),
                new Player("bbb", 0),
                new Player("ccc", 1)
        );

        winnerList = List.of(
                "aaa", "ccc"
        );
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 중간_결과_출력_확인() {
        outputView.printPartialResults(playerList);
        String consoleOutput = outContent.toString().trim();

        assertThat(consoleOutput).contains("aaa : -", "bbb : ", "ccc : -");
    }


    @Test
    void 최종_결과_출력_확인() {
        outputView.printFinalResults(winnerList);
        String consoleOutput = outContent.toString().trim();

        assertThat(consoleOutput).contains("최종 우승자 : aaa, ccc");
    }
}
