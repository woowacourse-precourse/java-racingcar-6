package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceGameUserInterfaceViewTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    void displayUserCarInputTest() {

        RaceGameUserInterfaceView.displayUserCarInput();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", outputMessage.toString());

    }

    @Test
    void displayTotalRoundTest() {

        RaceGameUserInterfaceView.displayTotalRoundInput();
        assertEquals("시도할 회수는 몇회인가요?\n", outputMessage.toString());

    }

    @Test
    void gameStartMessageTest() {

        RaceGameUserInterfaceView.raceGameStartMessage();
        assertEquals("\n실행 결과\n", outputMessage.toString());

    }

    @Test
    void displayUserCarDistanceTest() {

        LinkedHashMap<String, Integer> userCarDistance = new LinkedHashMap<>();
        userCarDistance.put("pobi", 3);
        userCarDistance.put("woni", 2);
        userCarDistance.put("jun", 4);

        RaceGameUserInterfaceView.displayUserCarDistance(userCarDistance);
        assertEquals("pobi : ---\n"
            + "woni : --\n"
            + "jun : ----\n\n", outputMessage.toString());
    }

    @Test
    void displayWinnerTest() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("jun");

        RaceGameUserInterfaceView.displayWinner(winners);
        assertEquals("최종 우승자 : pobi, jun", outputMessage.toString());
    }

    @Test
    void getInputTest() {
        String simulatedInput = "poby, wony, jun";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String input = RaceGameUserInterfaceView.getInput();
        assertEquals("poby, wony, jun", input);
    }
}