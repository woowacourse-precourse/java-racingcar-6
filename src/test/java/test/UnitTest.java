package test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.domain.Car;
import racingcar.domain.Constants;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class UnitTest {
    @Nested
    class InputViewTest {

        private static ByteArrayOutputStream outContent;
        InputView inputView = InputView.getInstance();

        @Test
        void displayCarNamePrompt() {
            outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            List<String> carList = inputView.displayCarNamePrompt();
            assertTrue(outContent.toString().contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"));
            assertThat(carList).isEqualTo(Arrays.asList("pobi", "hello", "exit"));
        }

        @Test
        void displayRaceCountPrompt() {
            String input = "pobi,hello,exit";
            ByteArrayInputStream carInput = new ByteArrayInputStream(input.getBytes());
            System.setIn(carInput);
            inputView.displayRaceCountPrompt();
            assertTrue(outContent.toString().contains("시도할 회수는 몇회인가요?"));
        }

        @Test
        void RaceCount() {
            String input = "3";
            ByteArrayInputStream raceCount = new ByteArrayInputStream(input.getBytes());
            System.setIn(raceCount);
            int result = inputView.RaceCount();
            assertEquals(3, result);
        }

    }

    @Nested
    class OutputViewTest {
        private static ByteArrayOutputStream outputStream;
        OutputView outputView = OutputView.getInstance();

        @BeforeAll
        public static void setStream() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        void displayGameWinner() {
            String result = "최종 우승자 : " + System.lineSeparator();
            outputView.displayGameWinner();
            assertThat(outputStream.toString()).isEqualTo(result);
        }

        @Test
        void displayGameResult() {
            String result = "실행 결과" + System.lineSeparator();
            outputView.displayGameResult();
            assertThat(outputStream.toString()).isEqualTo(result);
        }
    }

    @Nested
    class CarTest {

        @Test
        void moveFoward() {
            Car car = new Car("test");
            car.moveFoward(5);
            assertEquals(1, car.getPosition());

        }

        @Test
        void moveStop() {
            Car car = new Car("test");
            car.moveFoward(4);
            assertEquals(0, car.getPosition());

        }


    }

}
