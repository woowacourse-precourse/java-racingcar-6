package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class OutputViewTest {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String SEPARATOR = ", ";
    private ByteArrayOutputStream outputStream;

    private void setOut() {
        outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        System.setOut(out);
    }

    private String getWinnerMessage(List<String> winners) {
        return WINNER_MESSAGE + String.join(SEPARATOR, winners);
    }

    @BeforeEach
    void init() {
        setOut();
    }

    @DisplayName("\"실행 결과\"가 출력되어야 한다.")
    @Test
    void printPlayResultTest() {
        // given
        String resultMessage = "실행 결과";

        // when
        OutputView.printPlayResult();

        // then
        assertThat(outputStream.toString()).contains(resultMessage);
    }

    @DisplayName("레이스 결과가 출력되어야 한다.")
    @Test
    void printRaceResultTest() {
        // given
        String resultMessage = """
                pobi : -
                lastcow: --
                """;

        // when
        OutputView.printRaceResult(resultMessage);

        // then
        assertThat(outputStream.toString()).contains(resultMessage);
    }

    @DisplayName("단일 우승자가 출력되어야 한다.")
    @Test
    void printSingleWinnerTest() {
        // given
        List<String> winners = List.of("pobi");

        // when
        OutputView.printWinner(winners);

        // then
        assertThat(outputStream.toString()).contains(getWinnerMessage(winners));
    }

    @DisplayName("다수의 우승자가 출력되어야 한다.")
    @ParameterizedTest
    @MethodSource("getMultiWinners")
    void printMultiWinnerTest(List<String> winners) {
        // when
        OutputView.printWinner(winners);

        // then
        assertThat(outputStream.toString()).contains(getWinnerMessage(winners));
    }

    static Stream<List<String>> getMultiWinners() {
        return Stream.of(
                List.of("pobi", "lastcow"),
                List.of("pobi", "lastcow, jason"),
                List.of("pobi", "lastcow, jason, lisa, crong, honux, JK")
        );
    }
}