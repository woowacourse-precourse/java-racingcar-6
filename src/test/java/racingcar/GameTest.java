package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUpForTest() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testPrintRaceResultAndWinners() {
        Game testRace = new Game();
        ArrayList<Integer> testRaceResult = new ArrayList<>();
        testRaceResult.add(2);
        testRaceResult.add(4);

        Player player = new Player();
        ArrayList<String> testCars = player.createPlayerCarList("pobi, jun");
        testRace.printTotalLapResult(testRaceResult, testCars);

        Referee referee = new Referee();
        ArrayList<String> winners = referee.compare(testRaceResult, testCars);
        referee.printWinners(winners);

        assertThat(outputStreamCaptor.toString()).contains("pobi : --", "jun : ----", "최종 우승자 : jun");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
