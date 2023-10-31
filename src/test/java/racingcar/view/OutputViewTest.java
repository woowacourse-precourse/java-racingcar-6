package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.predicate;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach()
    void setEach() {
        outputView = new OutputView();
        System.setOut(new PrintStream(out));
    }

    @Test
    void test_Game_Start() {
        outputView.printStarting();
        outputView.printTimes();
        assertThat("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\r\n시도할 회수는 몇회인가요?\r\n").isEqualTo(out.toString());
    }

    @ParameterizedTest
    @CsvSource({"kim,5,-----", "son,1,-", "lee,10,----------"})
    void 선수_이동거리_출력(String player1, int distance, String dash) {

        List<String> player = new ArrayList<>(Arrays.asList(new String[]{player1}));
        int[] arrDistance = {distance};
        outputView.printRacing(player, arrDistance);
        assertThat(player1 + " : " + dash + "\r\n\r\n").isEqualTo(out.toString());

    }

}
