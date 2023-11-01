package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.GameResult;
import racingcar.model.dto.GameStatus;

class OutputViewTest {

    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setOutputStream() {
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("printStatus: 게임 상태 출력 테스트")
    void printStatus() {
        GameStatus state = new GameStatus("test", 10L);
        String result = "test : ----------\n";

        OutputView.printStatus(state);
        assertThat(out.toString()).isEqualTo(result);
    }

    @Test
    @DisplayName("printWinner: 우승자 출력 테스트 - 우승자 한명인 경우")
    void printWinner_한명() {
        List<String> winners = Arrays.asList("test1");
        String result = "최종 우승자 : test1\n";
        OutputView.printWinner(new GameResult(winners));

        assertThat(out.toString()).isEqualTo(result);
    }

    @Test
    @DisplayName("printWinner: 우승자 출력 테스트 - 우승자 여러명인 경우")
    void printWinner_여러명() {
        List<String> winners = Arrays.asList("test1", "test2", "test3");
        String result = "최종 우승자 : test1, test2, test3\n";
        OutputView.printWinner(new GameResult(winners));

        assertThat(out.toString()).isEqualTo(result);
    }
}