package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import racingcar.view.InputView;

public class UnitTest {
    @Nested
    class InputViewTest {

        private static ByteArrayOutputStream outContent;


        @Mock
        InputView inputView = InputView.getInstance();


        @BeforeAll
        public static void setUpStreams() {
            outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            String input = "pobi,hello,exit";
            ByteArrayInputStream carInput = new ByteArrayInputStream(input.getBytes());
            System.setIn(carInput);
        }

        @Test
        void displayCarNamePrompt() {
            List<String> carList = inputView.displayCarNamePrompt();
            assertTrue(outContent.toString().contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"));
            assertThat(carList).isEqualTo(Arrays.asList("pobi", "hello", "exit"));
        }

        @Test
        void displayRaceCountPrompt() {
            inputView.displayRaceCountPrompt();
            assertTrue(outContent.toString().contains("시도할 회수는 몇회인가요?"));
        }

    }

}
