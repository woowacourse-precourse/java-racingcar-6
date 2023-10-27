package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarGeneratorTest {

    @Test
    void createCarList() {
    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "pobi,jason,juno";
        String[] carList = input.split(",");
        assertThat(carList).contains("pobi", "jason", "juno");
        assertThat(carList).containsExactly("pobi", "jason", "juno");
    }
}