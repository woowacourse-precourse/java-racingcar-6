package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputTest {
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("pobi,woni", Arrays.asList("pobi", "woni")),
                Arguments.of("jun,pobi", Arrays.asList("jun", "pobi")));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 자동차의_이름을_쉼표로_구분해서_입력받기(String input, List<String> expected) {
        List<String> carNames = Input.readCarName(input);

        assertThat(carNames).isEqualTo(expected);
    }
}