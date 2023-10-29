package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private PrintStream standardOut;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restore() {
        System.setOut(standardOut);
        System.out.println(outputStream.toString());
    }

    @Test
    @DisplayName("자동차 이동의 실행 결과를 출력한다.")
    void printExecutionResult() {
        OutputView outputView = new OutputView();
        LinkedHashMap<String, Integer> carNamesAndMovingCount = new LinkedHashMap<>();
        carNamesAndMovingCount.put("park", 3);
        carNamesAndMovingCount.put("yong", 1);
        carNamesAndMovingCount.put("hyeon", 2);
        outputView.printExecutionResult(carNamesAndMovingCount);

        String[] output = outputStream.toString().split(System.lineSeparator());

        Assertions.assertThat(output).containsExactly("park : ---\nyong : -\nhyeon : --\n");
    }
}
