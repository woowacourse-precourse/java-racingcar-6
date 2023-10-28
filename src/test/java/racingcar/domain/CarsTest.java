package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void Cars의_from_메서드는_올바른_값이_주어지면_Cars_객체를_생성한다() {
        List<String> cars = List.of("pobi", "woni", "jun");

        assertThat(Cars.from(cars)).isInstanceOf(Cars.class);
    }
}
