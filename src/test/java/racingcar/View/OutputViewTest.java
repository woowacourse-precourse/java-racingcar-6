package racingcar.View;


import static racingcar.Message.OutputMessage.CAR_DELIMITER;
import static racingcar.Message.OutputMessage.WINNER_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;
import racingcar.Message.OutputMessage;

class OutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //when System.setOut(new PrintStream(outputStream));
    private final OutputView outputView = new OutputView();

    @Test
    void printResult() {
        //given
        List<String> raceResult = Arrays.asList("car1", "car2", "car3");

        //when
        System.setOut(new PrintStream(outputStream));
        outputView.printResult(raceResult);
        System.setOut(System.out);
        String expectedOutput = OutputMessage.RESULT_MESSAGE + "\ncar1\ncar2\ncar3";

        //then
        Assertions.assertThat(expectedOutput).isEqualTo(outputStream.toString().trim());
    }

    @Test
    void printResultMessage() {
        //when
        System.setOut(new PrintStream(outputStream));
        outputView.printResultMessage();
        System.setOut(System.out);

        //then
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(OutputMessage.RESULT_MESSAGE);
    }

    @Test
    void printRaceResult() {
        //given
        List<String> raceResult = Arrays.asList("car1", "car2", "car3");

        //when
        System.setOut(new PrintStream(outputStream));
        outputView.printRaceResult(raceResult);
        System.setOut(System.out);
        String expectedOutput = "car1\ncar2\ncar3";

        //then
        Assertions.assertThat(expectedOutput).isEqualTo(outputStream.toString().trim());
    }

    @Test
    void printWinner() {
        //given
        List<Car> raceResult = List.of(Car.create("car1"));

        //when
        System.setOut(new PrintStream(outputStream));
        outputView.printWinner(raceResult);
        System.setOut(System.out);
        String expectedOutput = WINNER_MESSAGE + CAR_DELIMITER + "car1";

        //then
        Assertions.assertThat(expectedOutput).isEqualTo(outputStream.toString().trim());
    }

    @Test
    void printSoleWinner() {
        //given
        List<Car> raceResult = List.of(Car.create("car1"));

        //when
        System.setOut(new PrintStream(outputStream));
        outputView.printSoleWinner(raceResult);
        System.setOut(System.out);
        String expectedOutput = WINNER_MESSAGE + CAR_DELIMITER + "car1";

        //then
        Assertions.assertThat(expectedOutput).isEqualTo(outputStream.toString().trim());
    }

    @Test
    void printWinners() {
        //given
        List<Car> raceResult = List.of(Car.create("car1"), Car.create("car3"));

        //when
        System.setOut(new PrintStream(outputStream));
        outputView.printWinners(raceResult);
        System.setOut(System.out);
        String expectedOutput = WINNER_MESSAGE + CAR_DELIMITER + "car1, car3";

        //then
        Assertions.assertThat(expectedOutput).isEqualTo(outputStream.toString().trim());
    }
}