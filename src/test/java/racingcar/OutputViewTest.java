package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 최종_우승자_출력() {
        OutputView outputView = new OutputView();
        List<String> winners = List.of("나", "윤", "kang", "na");
        outputView.printFinalResult(winners);

        assertThat(output.toString()).isEqualTo("최종 우승자 : 나, 윤, kang, na");
    }
}