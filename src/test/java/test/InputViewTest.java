package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {


    private static ByteArrayOutputStream outContent;
    InputView inputView = InputView.getInstance();

    @Test
    void displayCarNamePrompt() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        inputView.displayCarNamePrompt();
        assertTrue(outContent.toString().contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"));
    }

    @Test
    void displayRaceCountPrompt() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        inputView.displayRaceCountPrompt();
        assertTrue(outContent.toString().contains("시도할 회수는 몇회인가요?"));
    }

    @Test
    void getCarNamesTest() {
        String input = "pobi, exit";
        ByteArrayInputStream carNamesInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(carNamesInput);
        List<String> cars = inputView.getCarNames();
        assertTrue(cars.toString().contains(input));
    }

    @Test
    void getRaceCountTest() {
        int input = 3;
        String inputString = Integer.toString(input);
        ByteArrayInputStream raceCountInput = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(raceCountInput);
        int raceCount = inputView.getRaceCount();
        assertThat(raceCount).isEqualTo(input);
    }


}
