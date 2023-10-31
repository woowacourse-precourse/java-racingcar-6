package racingcar.input;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.validator.Validator;

class ConsoleInputCountTest {

    private Input consoleInput = new ConsoleInput(new Validator());

    @ParameterizedTest
    @MethodSource("provideExecutionCount")
    @DisplayName("실행 횟수 입력 시 실행 횟수 반환")
    void 실행_횟수_입력시_실행_횟수_반환(String input) {
        assertThat(run(input)).isEqualTo(Integer.parseInt(input));
    }

    static Stream<Arguments> provideExecutionCount() {
        return IntStream.rangeClosed(1, 1000)
                .mapToObj(count -> Arguments.of(String.valueOf(count)));
    }

    private int run(String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        int executionCount = consoleInput.receiveTotalCountOfExecution();

        Console.close();
        return executionCount;
    }
}