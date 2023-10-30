package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.service.CarService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    private CarService carService = new CarService();
    @DisplayName("자동차 이름 중복 예외 발생")
    @Test
    void duplicateCarName() {
        assertThatThrownBy(()->carService.stringToList("stlla,stlla"))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("자동차 이름 빈값 예외 발생")
    @Test
    void emptyCarName() {
        assertThatThrownBy(()->carService.stringToList(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("자동차 이름 null 예외 발생")
    @Test
    void nullCarName() {
        assertThatThrownBy(()->carService.stringToList(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
