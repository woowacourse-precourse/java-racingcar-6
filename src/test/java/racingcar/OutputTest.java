package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OutputTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    void 자동차_진행상황_출력_테스트() {
        final Output testOutput = new Output();
        final int testDistance = 5;
        System.setOut(new PrintStream(outputStreamCaptor));
        testOutput.printDashBoard(testDistance);

        assertThat(outputStreamCaptor.toString()).contains("-----");
        System.setOut(standardOut);
    }

    @Test
    void 최종_우승자_출력_테스트() {
        final Output testOutput = new Output();
        String[] testArr = {"vase", "line"};
        ArrayList<String> testWinnerList = new ArrayList<>();
        for (int i = 0; i < testArr.length; i++) {
            testWinnerList.add(testArr[i]);
        }
        System.setOut(new PrintStream(outputStreamCaptor));
        testOutput.printGameResult(testWinnerList);

        assertThat(outputStreamCaptor.toString()).contains("최종 우승자 : vase, line");
        System.setOut(standardOut);
    }
}
