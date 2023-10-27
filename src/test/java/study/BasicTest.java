package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BasicTest {


    @ParameterizedTest
    @MethodSource("listProvider")
    void testListSize(List<Integer> inputList, int expectedSize) {
        Assertions.assertThat(inputList).hasSize(expectedSize);
    }

    static Stream<Arguments> listProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), 3),
                Arguments.of(Arrays.asList(4, 5, 6, 7), 4),
                Arguments.of(Arrays.asList(8, 9, 10, 11, 12), 5)
        );
    }
}
