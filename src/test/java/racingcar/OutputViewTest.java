package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void resetStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void printExecResultTest_줄바꿈_실행결과_줄바꿈_문단을_출력() {
        OutputView.printExecResult();

        assertThat(output.toString()).isEqualTo("\r\n실행 결과\r\n");
    }

    @Test
    void printWinnerTest_우승자들을_출력함() {
        List<String> winnerName = new ArrayList<>();
        winnerName.add("pobi");
        winnerName.add("hoon");

        OutputView.printWinner(winnerName);

        assertThat(output.toString())
                .isEqualTo("최종 우승자 : pobi, hoon\r\n");
    }

    @Test
    void printCarStatusTest_전진상황을_출력함() {
        List<String> carName = new ArrayList<>();
        List<Integer> carStatus = new ArrayList<>();
        carName.add("a");
        carName.add("b");
        carName.add("c");
        carStatus.add(2);
        carStatus.add(3);
        carStatus.add(1);

        OutputView.printCarStatus(carName, carStatus);

        assertThat(output.toString())
                .isEqualTo("a : --\r\nb : ---\r\nc : -\r\n\r\n");
    }

    @Test
    void printInputCarNameTest_자동차_이름_입력받기전_구문_출력() {
        OutputView.printInputCarName();

        assertThat(output.toString())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\r\n");
    }

    @Test
    void printInputTryNumTest_시도회수_입력받기전_구문_출력() {
        OutputView.printInputTryNum();

        assertThat(output.toString()).isEqualTo("시도할 회수는 몇회인가요?\r\n");
    }
}
