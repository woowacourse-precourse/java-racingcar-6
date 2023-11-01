package custom_object;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @ParameterizedTest
    @MethodSource("tryMovingTestArguments")
    public void tryMovingTest(Car[] carArray, int[] answerArray) {
        int[] numberArray = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] resultArray = new int[carArray.length];

        for (int i = 0; i < numberArray.length; i++) {
            carArray[i % carArray.length].tryMoving(numberArray[i]);
        }

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = carArray[i].getPosition();
        }

        assertThat(resultArray).isEqualTo(answerArray);
    }

    public static Stream<Arguments> tryMovingTestArguments() {
        return Stream.of(
            Arguments.of(new Car[]{new Car("test1")}, new int[]{6}),
            Arguments.of(new Car[]{new Car("test1"), new Car("test2")}, new int[]{3,3})
        );
    }

    @ParameterizedTest
    @MethodSource("getNameTestArguments")
    public void getNameTest(Car[] carArray, String[] answerArray) {
        String[] resultArray = new String[carArray.length];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = carArray[i].getName();
        }

        assertThat(resultArray).isEqualTo(answerArray);
    }

    public static Stream<Arguments> getNameTestArguments() {
        return Stream.of(
                Arguments.of(new Car[]{new Car("test1")}, new String[]{"test1"}),
                Arguments.of(new Car[]{new Car("test1"), new Car("test2")}, new String[]{"test1","test2"})
        );
    }
}
