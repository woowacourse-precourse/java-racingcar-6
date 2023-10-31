package jalddak.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.view.OutputView.printPerMatchResult;
import static racingcar.view.OutputView.printSystemMessage;
import static racingcar.view.OutputView.printWinner;
import static racingcar.view.SystemMessage.ASK_CAR_LIST;
import static racingcar.view.SystemMessage.ASK_NUM_OF_MATCHES;
import static racingcar.view.SystemMessage.TESTING;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

public class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 출력확인_printSystemMessage() {
        //given
        String expect = ASK_CAR_LIST.getMessage() + "\n"
                + ASK_NUM_OF_MATCHES.getMessage() + "\n"
                + TESTING.getMessage() + "\n";

        //when
        printSystemMessage(ASK_CAR_LIST);
        printSystemMessage(ASK_NUM_OF_MATCHES);
        printSystemMessage(TESTING);

        //then
        assertThat(output.toString()).isEqualTo(expect);
    }

    @Test
    void 출력확인_printAllMatchesResult() {
        //given
        Map<String, Integer> testData = new LinkedHashMap<>();
        testData.put("HJ", 4);
        testData.put("HS", 2);
        testData.put("SJ", 7);

        String expect = "HJ : ----\nHS : --\nSJ : -------\n\n";

        //when
        printPerMatchResult(testData);

        //then
        assertThat(output.toString()).isEqualTo(expect);
    }

    @Test
    void drawDistance() {
        // given
        String expect = "----";

        //when
        String result = OutputView.drawDistance(4);

        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 우승자_한명_printWinner() {
        //given
        List<String> one = new ArrayList<>();
        one.add("HJ");

        String expect = "최종 우승자 : HJ\n";

        //when
        printWinner(one);

        //then
        assertThat(output.toString()).isEqualTo(expect);

    }

    @Test
    void 우승자_여러명_printWinner() {
        //given
        List<String> several = new ArrayList<>();
        several.add("HJ");
        several.add("HS");
        several.add("RK");

        String expect = "최종 우승자 : HJ, HS, RK\n";

        //when
        printWinner(several);

        //then
        assertThat(output.toString()).isEqualTo(expect);
    }
}
