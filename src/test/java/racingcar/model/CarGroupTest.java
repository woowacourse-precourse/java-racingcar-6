package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupTest {

    @ParameterizedTest
    @MethodSource("provideCarGroupTestArgument")
    void 우승_자동차들을_찾는다(List<Integer> positions, List<String> results) {
        CarGroup carGroup = new CarGroup(List.of("자동차1", "자동차2", "자동차3"), new TestRandomNumberFactory(positions));
        carGroup.race();
        List<String> winners = carGroup.findWinnerNames();
        assertThat(winners).isEqualTo(results);
    }


    static List<Arguments> provideCarGroupTestArgument() {
        return Arrays.asList(
                Arguments.of(List.of(9, 9, 9), List.of("자동차1", "자동차2", "자동차3")),
                Arguments.of(List.of(1, 1, 9), List.of("자동차3")),
                Arguments.of(List.of(1, 9, 9), List.of("자동차2", "자동차3"))
        );
    }

    private class TestRandomNumberFactory implements NumberGenerator {

        private List<Integer> numbers;

        public TestRandomNumberFactory(List<Integer> numbers) {
            this.numbers = new ArrayList<>(numbers);
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
