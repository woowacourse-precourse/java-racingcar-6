package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

public class OutputTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    void 단독_우승자_문구_출력_기능(){
        System.setOut(new PrintStream(outContent));

        OutputView.printSoloWinner("jin");
        System.setOut(originalOut);

        assertThat(outContent.toString()).contains("최종 우승자 : jin");
    }

    @Test
    void 공동_우승자_문구_출력_기능(){
        System.setOut(new PrintStream(outContent));

        List<String> winner = new ArrayList<>();
        winner.add("jin");
        winner.add("ive");

        OutputView.printJointWinner(winner);
        System.setOut(originalOut);

        assertThat(outContent.toString()).contains("최종 우승자 : jin, ive");
    }
}
