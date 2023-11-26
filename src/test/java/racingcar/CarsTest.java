package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.view.InputView;

public class CarsTest {
    private final InputView inputView = new InputView();

    static Stream<Arguments> invalidCarInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList("lamborghini", "ferrari")),
                Arguments.of(Arrays.asList("lamborghini", "white")),
                Arguments.of(Arrays.asList("자동차", "white")),
                Arguments.of(Arrays.asList("자동차", "페라리")),
                Arguments.of(Arrays.asList("", " ")),
                Arguments.of(Arrays.asList("j u n", "woni "," pobi")),
                Arguments.of(Arrays.asList("woni","woni"))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidCarInputs")
    void validateCarInput(List<String> carNames) {
        assertThrows(IllegalArgumentException.class, () -> inputView.validateCarsInput(carNames));
    }
}
