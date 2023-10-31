package racingcar.view;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OutputMessageTest {

    @Test
    void 현재_게임_진행_상태를_출력() {
        String[] carPositions = { "car1 : -", "car2 : --", "car3 : ---" };
        int carsCount = carPositions.length;

        String expectedOutput = "car1 : -\ncar2 : --\ncar3 : ---\n\n";

        String actualOutput = OutputMessage.printGameStatusMessage(carPositions, carsCount);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void 최종_게임_승리자가_여러명일때_출력() {

        List<String> winners = List.of("car1", "car3", "car5");

        String expectedOutput = "car1,car3,car5";

        String actualOutput = OutputMessage.printWinnerMessage(winners);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void 최종_게임_승리자가_한_명_일때_출력() {

        List<String> winners = List.of("car1");

        String expectedOutput = "car1";

        String actualOutput = OutputMessage.printWinnerMessage(winners);

        assertEquals(expectedOutput, actualOutput);

    }
}
