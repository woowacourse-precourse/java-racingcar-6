package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Cars;
import racingcar.view.InputView;
import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {

    @ParameterizedTest
    @MethodSource("provideNamesForValidate")
    void 자동차_이름_입력값_검증_테스트(String[] carNames) {
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNamesForValidate() {
        return Stream.of(
                Arguments.of((Object) new String[] {"jy", "jy", "wb"}),
                Arguments.of((Object) new String[] {"jy", "juyeon", "wb"}),
                Arguments.of((Object) new String[] {"jy", "", "wb"}),
                Arguments.of((Object) new String[] {"jy", " ", "wb"})
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"+4", "ss", "-1", "0"})
    void 라운드_수_입력값_검증_테스트(String input) {
        generateInput(input);
        assertThatThrownBy(InputView::inputRoundNumber)
                .isInstanceOf(IllegalArgumentException.class);

        Console.close();
    }

    private void generateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
