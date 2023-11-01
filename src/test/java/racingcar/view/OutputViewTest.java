package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 실행결과_안내문_출력() {
        OutputView.printProgressStmt();

        assertThat(outputStream.toString()).isEqualTo("\n실행 결과\n");
    }

    @Test
    void 한_턴_실행_결과_출력() {
        List<String> inputCars = Arrays.asList("a", "b", "c");
        List<Integer> inputCarPos = Arrays.asList(1, 2, 3);

        OutputView.printOneTurnResult(inputCars, inputCarPos);
        String expected = "a : -\n" + "b : --\n" + "c : ---\n\n";

        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    void 최종_우승자_출력_한명() {
        List<String> winner = Arrays.asList("a");

        OutputView.printWinnerResult(winner);
        String expected = "최종 우승자 : a\n";

        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    void 최종_우승자_출력_여러명() {
        List<String> winner = Arrays.asList("a", "b");

        OutputView.printWinnerResult(winner);
        String expected = "최종 우승자 : a, b\n";

        assertThat(outputStream.toString()).isEqualTo(expected);
    }
}
