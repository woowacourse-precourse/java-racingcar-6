package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarInputViewTest {

    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(OUTPUT));
    }

    @AfterEach
    public void restore() {
        Console.close();
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @MethodSource("provideInputCarNamesTestArguments")
    public void inputCarNamesTest(String names, List<String> expected) {
        System.setIn(generateUserInput(names));
        RacingCarInputView racingCarInputView = new RacingCarInputView();
        List<String> carNames = racingCarInputView.inputCarNames();
        for (int i = 0; i < carNames.size(); i++) {
            assertThat(carNames.get(i)).isEqualTo(expected.get(i));
        }
        assertThat(OUTPUT.toString()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    static Stream<Arguments> provideInputCarNamesTestArguments() {
        return Stream.of(
                arguments("java,jigi", List.of("java", "jigi")),
                arguments("java, wrong", List.of("java", " wrong")),
                arguments("java,,jigi", List.of("java", "", "jigi")),
                arguments("java#!@#$ ,jigi", List.of("java#!@#$ ", "jigi"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "200000000"})
    void inputAttemptCountsTest(String attempt) {
        System.setIn(generateUserInput(attempt));
        RacingCarInputView racingCarInputView = new RacingCarInputView();
        String stringAttemptCounts = racingCarInputView.inputAttemptCounts();
        assertThat(OUTPUT.toString()).isEqualTo("시도할 횟수는 몇회인가요?\n");
        assertThat(stringAttemptCounts).isEqualTo(attempt);
    }
}
