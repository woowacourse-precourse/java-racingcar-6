package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class NamesTest {
    private Names names;

    @Test
    void toCars_확인() {
        names = new Names("a,b");
        Cars cars = names.toCars();
        List<Car> expected = Arrays.asList(new Car("a"), new Car("b"));
        assertThat(cars.getCars()).usingRecursiveComparison().isEqualTo(expected);
    }

}