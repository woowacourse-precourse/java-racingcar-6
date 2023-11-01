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

    @Test
    public void 중복되는_이름을_가진_자동차가_있는_경우_예외_발생() {
        String input = "pobi,pobi";
        Cars cars = new Cars(input);
        assertThatThrownBy(() -> cars.duplicateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 중복되지 않은 고유한 값이어야 합니다.");
    }

}
