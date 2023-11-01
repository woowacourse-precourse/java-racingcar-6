package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.View.OutputView;

public class OutputViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 우승자_출력테스트() {
        // given
        ArrayList<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("jun");
        OutputView ov = new OutputView();
        ov.printWinners(winners);

        // when
        String expected = "최종 우승자 : pobi, jun\n";

        // then
        assertThat(outputStreamCaptor.toString()).isEqualTo(expected);
    }

    @Test
    void 라운드_출력테스트()

    }
}
