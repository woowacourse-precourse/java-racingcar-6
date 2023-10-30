package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.utils.Movement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupTest {

    @ParameterizedTest
    @MethodSource("provideFindWinnersInformation")
    void findWinnerNames_는_우승_자동차_이름을_반환한다(List<Boolean> moves, List<String> results) {
        CarGroup carGroup = new CarGroup(List.of("자동차1", "자동차2", "자동차3"), new TestMovement(moves));
        carGroup.race();
        List<String> winners = carGroup.findWinnerNames();
        assertThat(winners).isEqualTo(results);
    }

    static List<Arguments> provideFindWinnersInformation() {
        return Arrays.asList(
                Arguments.of(List.of(true, true, true), List.of("자동차1", "자동차2", "자동차3")),
                Arguments.of(List.of(false, false, true), List.of("자동차3")),
                Arguments.of(List.of(false, true, true), List.of("자동차2", "자동차3"))
        );
    }

    class TestMovement implements Movement {
        List<Boolean> values;

        TestMovement(List<Boolean> values) {
            this.values = new ArrayList<>(values);
        }

        @Override
        public boolean canMove() {
            return values.remove(0);
        }
    }

}
