package manager;

import custom_object.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;

public class GameInitializerTest {

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @ParameterizedTest
    @MethodSource("inputCarNameTestArguments")
    @DisplayName("inputCarNameTest")
    public void inputCarNameTest(String[] carNameArray, String[] answerArray) {
        Car[] resultArray = new Car[carNameArray.length];
        String[] resultStringifyArray = new String[carNameArray.length];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = new Car(carNameArray[i]);
            resultStringifyArray[i] = resultArray[i].getName() + "-" + resultArray[i].getPosition();
        }

        assertThat(resultStringifyArray).isEqualTo(answerArray);
    }

    public static Stream<Arguments> inputCarNameTestArguments() {
        return Stream.of(
                Arguments.of(new String[]{"test1"}, new String[]{"test1-0"}),
                Arguments.of(new String[]{"test1", "test2"}, new String[]{"test1-0", "test2-0"})
        );
    }

    @ParameterizedTest
    @MethodSource("inputNumbersOfMatchTestArguments")
    @DisplayName("inputNumbersOfMatchTest")
    public void inputNumbersOfMatchTest(String numberOfMatch, int answer) {
        GameInitializer gameInitializer = new GameInitializer();
        int result;

        provideInput(numberOfMatch);
        result = gameInitializer.inputNumbersOfMatch();

        Console.close();

        assertThat(result).isEqualTo(answer);
    }

    public static Stream<Arguments> inputNumbersOfMatchTestArguments() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("2", 2),
                Arguments.of("3", 3)
        );
    }
}
