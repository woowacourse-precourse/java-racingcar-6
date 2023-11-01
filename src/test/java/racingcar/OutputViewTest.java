package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.View.OutputView;
import racingcar.model.Cars;

public class OutputViewTest {
    private OutputView ov;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        ov = new OutputView();
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
        ov.printWinners(winners);

        // when
        String expected = "최종 우승자 : pobi, jun";

        // then
        assertThat(outputStreamCaptor.toString()).isEqualTo(expected);
    }

    @Test
    void 자동차진행상황출력테스트(){
        String name = "vvi";
        int position = 9;

        String expected = "vvi : ---------";
        ov.printCarResult(name, position);

        assertThat(outputStreamCaptor.toString()).isEqualTo(expected);

    }

}
