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

        assertThat(outputStream.toString())
                .isEqualTo("pobi : ---\n" +
                        "woni : ---\n" +
                        "jun : -----\n\n");
    }

    @Test
    void printForwards_전진_현황_출력() {
        Car car = new Car("pobi", 3);

        racingService.printForwards(car);

        assertThat(outputStream.toString())
                .isEqualTo("---");
    }

    @Test
    void pickWinner_공동_우승자인_경우() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 4),
                new Car("woni", 3),
                new Car("jun", 4)
        );

        List<String> winners = racingService.pickWinner(cars);

        assertThat(winners).containsOnly("pobi","jun");
    }

    @Test
    void pickWinner_단독_우승자인_경우() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 4),
                new Car("woni", 3),
                new Car("jun", 2)
        );

        List<String> winners = racingService.pickWinner(cars);

        assertThat(winners).containsOnly("pobi");
    }

    @Test
    void printWinner_공동_우승자_출력() {
        List<String> winners = Arrays.asList("pobi", "woni");

        racingService.printWinners(winners);

        assertThat(outputStream.toString())
                .isEqualTo("최종 우승자 : pobi, woni");
    }

    @Test
    void printWinner_단독_우승자_출력() {
        List<String> winners = Arrays.asList("pobi");

        racingService.printWinners(winners);

        assertThat(outputStream.toString())
                .isEqualTo("최종 우승자 : pobi");
    }
}
