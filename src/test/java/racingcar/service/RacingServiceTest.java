package racingcar.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingServiceTest {
    RacingService racingService = new RacingService();
    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }
    @Test
    void stringToList_쉼표를_구분자로_리스트_변환() {
        String input = "pobi,woni,jun";
        List<String> inputList = racingService.stringToList(input);

        assertThat(inputList).containsOnly("pobi", "woni", "jun");
    }

    @Test
    void printAttemptResult_실행결과_출력() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 3),
                new Car("woni", 3),
                new Car("jun", 5));

        racingService.printAttemptResult(cars);

        assertThat(outputStream.toString()).
                isEqualTo("pobi : ---\n" +
                        "woni : ---\n" +
                        "jun : -----\n\n");
    }

    @Test
    void pickWinner_중복_우승자인_경우() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 4),
                new Car("woni", 3),
                new Car("jun", 4)
        );

        List<String> winners = racingService.pickWinner(cars);

        assertThat(winners).containsOnly("pobi","jun");
    }
}
