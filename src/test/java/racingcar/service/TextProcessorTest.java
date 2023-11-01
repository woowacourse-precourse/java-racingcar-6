package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.exception.ExceptionMessage;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextProcessorTest {
    private final TextProcessor textProcessor = new TextProcessor();

    @Test
    @DisplayName("이동횟수_입력_타입_변환")
    void tryCountInput() {
        String input = "60";

        int result = textProcessor.parseTryNumber(input);

        assertThat(result)
                .isEqualTo(60);
        assertThat(result)
                .isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("이동횟수_미입력_예외")
    void tryCountInputEmptyException() {
        String input = "";

        assertThatThrownBy(
                () -> textProcessor.parseTryNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_TRY_COUNT
                        .getErrorMessage());
    }

    @Test
    @DisplayName("이동횟수_미입력_예외")
    void tryCountInputNegativeValueException() {
        String input = "-230";

        assertThatThrownBy(
                () -> textProcessor.parseTryNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NEGATIVE_VALUE_TRY_COUNT
                        .getErrorMessage());
    }

    @Test
    @DisplayName("이동횟수_정수변환_예외")
    void tryCountInputParseException() {
        String input = "12t";

        assertThatThrownBy(
                () -> textProcessor.parseTryNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INTEGER_FORMAT
                        .getErrorMessage());
    }

    @Test
    @DisplayName("공백제거한_문자열_분리")
    void trimWhitespaceSplitCarNames() {
        String input = " test1, test2 , test3";
        String[] result = {"test1", "test2", "test3"};

        assertThat(textProcessor.splitCarNames(input))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("우승자_문자열_통합")
    void winnersJoin() {
        String[] inputArray = {"test1", "test2", "test3"};
        List<String> input = new ArrayList<>(Arrays.asList(inputArray));

        String result = "test1, test2, test3";

        assertThat(textProcessor.joinText(input))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("차_진행사항_출력_문자열")
    void carsDistanceAsString() {
        Cars cars = Mockito.mock(Cars.class);

        Car car1 = Mockito.mock(Car.class);
        Car car2 = Mockito.mock(Car.class);

        Mockito.when(car1.getName())
                .thenReturn("test1");
        Mockito.when(car2.getName())
                .thenReturn("test2");
        Mockito.when(car1.getDistance())
                .thenReturn(2);
        Mockito.when(car2.getDistance())
                .thenReturn(1);

        Mockito.when(cars.getCars())
                .thenReturn(Arrays.asList(car1, car2));

        String result = """
                test1 : --
                test2 : -
                """;

        assertThat(textProcessor.carsDistanceAsString(cars))
                .isEqualTo(result);
    }
}
