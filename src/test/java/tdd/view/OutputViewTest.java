package tdd.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    private void doTest(String message) {
        assertThat(output.toString()).isEqualTo(message);
        System.setOut(System.out);
        output.reset();
    }


    @Test
    void 올바른_자동차_입력_메시지_출력시_통과() {
        String message = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

        setUpStreams();
        OutputView.printCarNameInputMessage();
        doTest(message);
    }
    @Test
    void 올바른_자동차_입력_요구_메시지_출력시_통과() {
        String message = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

        setUpStreams();
        OutputView.printCarNameInputMessage();
        doTest(message);
    }
    @Test
    void 올바른_시도_횟수_입력_메시지_출력시_통과() {
        String message = "시도할 회수는 몇회인가요?\n";

        setUpStreams();
        OutputView.printAttemptCountInputMessage();
        doTest(message);
    }

    @Test
    void 올바른_실행_결과_메시지_출력시_통과() {
        String message = "실행 결과\n";

        setUpStreams();
        OutputView.printGameResultMessage();
        doTest(message);
    }

    @Test
    void 올바른_이동_결과_메시지_출력시_통과() {
        String message = "Car1 : -\n";

        setUpStreams();
        OutputView.printRoundResult("Car1", 1);
        doTest(message);
    }

    @Test
    void 올바른_최종_우승자_메시지_출력시_통과() {
        List<String> winners = new ArrayList<>();
        winners.add("Car1");
        winners.add("Car2");

        String message = "최종 우승자 : Car1, Car2\n";

        setUpStreams();
        OutputView.printWinner(winners);
        doTest(message);
    }
}
