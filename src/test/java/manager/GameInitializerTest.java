package manager;

import custom_object.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameInitializerTest {
    @ParameterizedTest
    @MethodSource("inputCarNameTestArguments")
    @DisplayName("inputCarNameTest")
    public void inputCarNameTest(String[] carNameArray, String[] answerArray) {
        Car[] resultArray = new Car[carNameArray.length];
        String[] resultStringifyArray = new String[carNameArray.length];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = new Car(carNameArray[i]);
            resultStringifyArray[i] = resultArray[i].getName()+"-"+resultArray[i].getPosition();
        }

        assertThat(resultStringifyArray).isEqualTo(answerArray);
    }

    public static Stream<Arguments> inputCarNameTestArguments() {
        return Stream.of(
                Arguments.of(new String[]{"test1"}, new String[]{"test1-0"}),
                Arguments.of(new String[]{"test1", "test2"}, new String[]{"test1-0", "test2-0"})
        );
    }
}
