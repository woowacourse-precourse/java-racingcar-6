package racingcar.view.output;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.GameResult;
import racingcar.model.Car;
import racingcar.view.GameMessage;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewImplTest {

    OutputStream output;
    OutputView outputView = new OutputViewImpl();

    @BeforeEach
    void before() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void after() {
        System.setOut(System.out);
    }

    @Test
    void 자동차_이름_입력_메시지를_출력한다() {
        // given
        String expected = GameMessage.START.getMessage() + "\n";

        // when
        outputView.printInputCarNamesMessage();

        // then
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void 시도할_횟수를_묻는_메시지를_출력한다() {
        // given
        String expected = GameMessage.ASK_RETRY_COUNT.getMessage() + "\n";

        // when
        outputView.printInputRetryCountMessage();

        // then
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void 게임결과를_출력한다() {
        // given
        List<List<GameResult>> totalGameResults = makeTotalGameResults();
        String expected = makeTotalGameResultsExpected();

        // when
        outputView.printTotalGameResults(totalGameResults);

        // then
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void 최종_우승자를_출력한다() {
        // given
        List<String> winners = List.of("pobi", "woni");
        String expected = GameMessage.WINNER.getMessage().formatted("pobi, woni") + "\n";

        // when
        outputView.printWinners(winners);

        // then
        assertThat(output.toString()).isEqualTo(expected);
    }

    private Car makeCar(String name, int positionValue, String viewPositionValue) throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car(name);

        Class<Car> carClass = Car.class;
        Field position = carClass.getDeclaredField("position");
        Field viewPosition = carClass.getDeclaredField("viewPosition");

        position.setAccessible(true);
        viewPosition.setAccessible(true);

        position.set(car, positionValue);
        viewPosition.set(car, viewPositionValue);

        return car;
    }

    private List<List<GameResult>> makeTotalGameResults() {
        List<GameResult> round1 = List.of(
                new GameResult("pobi", "-"),
                new GameResult("woni", "-")
        );

        List<GameResult> round2 = List.of(
                new GameResult("pobi", "--"),
                new GameResult("woni", "-")
        );

        List<GameResult> round3 = List.of(
                new GameResult("pobi", "--"),
                new GameResult("woni", "--")
        );

        return List.of(round1, round2, round3);
    }

    private String makeGameResultsString(String name, String position) {
        return GameMessage.PERSONAL_RESULT.getMessage().formatted(name, position) + "\n";
    }

    private String makeTotalGameResultsExpected() {
        StringBuilder sb = new StringBuilder();
        sb.append(makeGameResultsString("pobi", "-"));
        sb.append(makeGameResultsString("woni", "-"));
        sb.append("\n");
        sb.append(makeGameResultsString("pobi", "--"));
        sb.append(makeGameResultsString("woni", "-"));
        sb.append("\n");
        sb.append(makeGameResultsString("pobi", "--"));
        sb.append(makeGameResultsString("woni", "--"));
        sb.append("\n");
        return sb.toString();
    }
}