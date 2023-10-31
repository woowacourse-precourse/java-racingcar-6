package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private static ByteArrayOutputStream outputMessage;
    private OutputView outputView;

    @BeforeEach
    void beforeEach() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
    }

    public OutputViewTest() {
        this.outputView = OutputView.getInstance();
    }

    @Test
    public void OutputView() {
        OutputView outputView1 = OutputView.getInstance();
        OutputView outputView2 = OutputView.getInstance();

        assertEquals(outputView1, outputView2);
    }

    @Test
    public void promptCarNames() {
        outputView.promptCarNames();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", outputMessage.toString());
    }

    @Test
    public void promptNumberOfGameAttempts() {
        outputView.promptNumberOfGameAttempts();
        assertEquals("시도할 회수는 몇회인가요?\n", outputMessage.toString());
    }

    @Test
    public void printGameResult() {
        outputView.printGameResult();
        assertEquals("\n실행 결과\n", outputMessage.toString());
    }

    @Test
    public void printGameResultsPerAttempt_success() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        List<Integer> movingDistances = List.of(1, 2, 3);
        String expectedGameResult = "pobi : -\nwoni : --\njun : ---\n\n";

        outputView.printGameResultsPerAttempt(carNames, movingDistances);
        assertEquals(expectedGameResult, outputMessage.toString());
    }

    @Test
    public void printGameResultsPerAttempt_fail() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        List<Integer> movingDistances = List.of(1, 2, 3, 4);

        assertThrows(IllegalArgumentException.class,
            () -> outputView.printGameResultsPerAttempt(carNames, movingDistances)
        );
    }

    @Test
    public void printWinnersOfGame(){
        List<String> winners = List.of("pobi", "woni", "jun");
        String expectedWinnersMessage = "최종 우승자 : pobi, woni, jun\n";

        outputView.printWinnersOfGame(winners);
        assertEquals(expectedWinnersMessage, outputMessage.toString());
    }
}