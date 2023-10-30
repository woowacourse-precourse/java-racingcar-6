package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.TestNumberGenerator;

class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 자동차_모두_전진_결과_출력테스트() {
        List<Car> carList = Arrays.asList(
                new Car("pobi", new TestNumberGenerator(7)),
                new Car("woni", new TestNumberGenerator(8)),
                new Car("jun", new TestNumberGenerator(9))
        );
        Game game = new Game(carList);
        game.playOneRound();
        OutputView.printResult(game.getCars());

        String expectedOutput = "pobi : -\n" + "woni : -\n" + "jun : -\n\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 자동차_모두_멈춤_결과_출력테스트() {
        List<Car> carList = Arrays.asList(
                new Car("pobi", new TestNumberGenerator(1)),
                new Car("woni", new TestNumberGenerator(2)),
                new Car("jun", new TestNumberGenerator(3))
        );
        Game game = new Game(carList);
        game.playOneRound();
        OutputView.printResult(game.getCars());

        String expectedOutput = "pobi : \n" + "woni : \n" + "jun : \n\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 우승자_두명일때_출력테스트() {
        List<String> winners = Arrays.asList("pobi", "woni");
        OutputView.printWinnerMessage(winners);

        String expectedOutput = "최종 우승자 : pobi,woni\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 우승자_한명일때_출력테스트() {
        List<String> winners = Arrays.asList("pobi");
        OutputView.printWinnerMessage(winners);

        String expectedOutput = "최종 우승자 : pobi\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
