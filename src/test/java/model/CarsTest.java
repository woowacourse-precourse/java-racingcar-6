package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    public void 자동차들_생성() {
        String input = "pobi,jun,woni";
        Cars cars = new Cars(input);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    public void 자동차들_생성_실패() {
        String input = "pobi, jun, woni";
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
