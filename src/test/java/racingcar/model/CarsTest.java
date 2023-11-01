package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exception.ErrorCode;
import racingcar.model.intgenerator.CustomIntGenerator;

public class CarsTest {
    @Test
    void 자동차들_생성시_이름이_중복되면_예외가_발생한다() {
        List<String> names = List.of("pobi", "pobi");

        assertThatThrownBy(() -> Cars.fromNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATE_NAME.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "3,0", "5,1", "9,1"}, delimiter = ',')
    void 자동차들_이동_시_고른_숫자가_기준점을_넘은_자동차들만_전진횟수가_증가한다(int pickedNumber, int expectedForwardCount) {
        List<String> names = List.of("pobi", "woni");
        Cars cars = Cars.fromNamesWithIntGenerator(names, new CustomIntGenerator(pickedNumber));

        cars.move();

        assertThat(cars.collectAllState())
                .allMatch(state -> state.forwardCount() == expectedForwardCount);
    }
}
