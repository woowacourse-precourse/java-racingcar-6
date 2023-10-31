package racingcar.output;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.Car;

class ConsoleOutputExecutionResultTest {

    private Output consoleOutput = new ConsoleOutput();

    @ParameterizedTest
    @MethodSource("provideCarList")
    @DisplayName("차수별 실행 결과 출력")
    void 차수별_실행_결과_출력(List<Car> carList, List<String> result) {
        assertThat(run(carList)).contains(result);
    }

    static Stream<Arguments> provideCarList() {
        return PrintExecutionResultTestCase.getArgumentsStream();
    }

    private String run(List<Car> carList) {
        OutputStream print = new ByteArrayOutputStream();
        System.setOut(new PrintStream(print));

        consoleOutput.printExecutionResult(carList);
        return print.toString();
    }
}