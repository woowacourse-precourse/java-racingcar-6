package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests class RaceGameUserInterfaceView method function correctly
 */
class RaceGameUserInterfaceViewTest {
    private static ByteArrayOutputStream outputMessage;

    /**
     * Sets up for console I/O tests
     */
    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    /**
     * Sets up for console I/O tests
     */
    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    /**
     * Tests method displayUserCarInput if it outputs correctly
     */
    @Test
    void displayUserCarInputTest() {
        // when
        RaceGameUserInterfaceView.displayUserCarInput();

        // then
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", outputMessage.toString());

    }

    /**
     * Tests method displayTotalRound if it outputs correctly
     */
    @Test
    void displayTotalRoundTest() {
        // when
        RaceGameUserInterfaceView.displayTotalRoundInput();

        // then
        assertEquals("시도할 회수는 몇회인가요?\n", outputMessage.toString());

    }

    /**
     * Tests method displayRaceGameStartMessage if it outputs correctly
     */
    @Test
    void displayRaceGameStartMessageTest() {
        // when
        RaceGameUserInterfaceView.displayRaceGameStartMessage();

        // then
        assertEquals("\n실행 결과\n", outputMessage.toString());

    }

    /**
     * Tests method displayUserCarDistance if it outputs correctly
     */
    @Test
    void displayUserCarDistanceTest() {
        // given
        LinkedHashMap<String, Integer> userCarDistance = new LinkedHashMap<>();
        userCarDistance.put("pobi", 3);
        userCarDistance.put("woni", 2);
        userCarDistance.put("jun", 4);

        // when
        RaceGameUserInterfaceView.displayUserCarDistance(userCarDistance);

        // then
        assertEquals("pobi : ---\n" + "woni : --\n" + "jun : ----\n\n", outputMessage.toString());
    }

    /**
     * Tests method displayWinner if it outputs correctly
     */
    @Test
    void displayWinnerTest() {
        // given
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("jun");

        // when
        RaceGameUserInterfaceView.displayWinner(winners);

        // then
        assertEquals("최종 우승자 : pobi, jun", outputMessage.toString());
    }

    /**
     * Tests method getInput if it takes inputs correctly
     */
    @Test
    void getInputTest() {
        // given
        String simulatedInput = "poby, wony, jun";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // when
        String input = RaceGameUserInterfaceView.getInput();

        // then
        assertEquals("poby, wony, jun", input);
    }
}