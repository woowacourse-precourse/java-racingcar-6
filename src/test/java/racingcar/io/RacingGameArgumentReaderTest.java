package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class RacingGameArgumentReaderTest {

    @Test
    void 자동차_이름를_입력받아서_리스트로_반환한다() {
        //given
        InputReader mockInputReader = mock(InputReader.class);
        when(mockInputReader.readLine()).thenReturn("car1,car2,car3");
        GameArgumentReader gameArgumentReader = new GameArgumentReader(mockInputReader);

        //when
        List<String> carNames = gameArgumentReader.readCarNames();

        //then
        assertThat(carNames).isEqualTo(Arrays.asList("car1", "car2", "car3"));
    }

    @MethodSource("carNamesProvider")
    @ParameterizedTest
    void 자동차_이름이_올바르지_않으면_예외가_발생한다(String carNames) {
        //given
        InputReader mockInputReader = mock(InputReader.class);
        when(mockInputReader.readLine()).thenReturn(carNames);
        GameArgumentReader gameArgumentReader = new GameArgumentReader(mockInputReader);

        //when //then
        Assertions.assertThatThrownBy(() -> gameArgumentReader.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<String> carNamesProvider() {
        return Stream.of("pobi,javaji", "", " , ");
    }

    @Test
    void 시도_횟수를_입력받아서_반환한다() {
        //given
        InputReader mockInputReader = mock(InputReader.class);
        String input = "5";
        when(mockInputReader.readLine()).thenReturn(input);
        GameArgumentReader gameArgumentReader = new GameArgumentReader(mockInputReader);

        //when
        String attemptNumber = gameArgumentReader.readAttemptNumber();

        //then
        assertThat(attemptNumber).isEqualTo(input);
    }

    @CsvSource({"a", "0", "' '", "abcd"})
    @ParameterizedTest
    void 시도_횟수가_올바르지_않으면_예외가_발생한다(String attemptNumber) {
        //given
        InputReader mockInputReader = mock(InputReader.class);
        when(mockInputReader.readLine()).thenReturn(attemptNumber);
        GameArgumentReader gameArgumentReader = new GameArgumentReader(mockInputReader);

        //when//then
        Assertions.assertThatThrownBy(() -> gameArgumentReader.readAttemptNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}