package racingcar.model.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class CarListTest {

    @Test
    @DisplayName("가장 높은 전진횟수를 구한다.")
    void getMaxForwardCount_Cars_MaxForwardCount() {
        // Given
        final int expectCount = 3;
        final List<Car> cars = List.of(
                new Car("다나카", expectCount),
                new Car("트럼프", 2));

        // When
        int result = new CarList(cars).getMaxForwardCount();

        // Then
        assertThat(result).isEqualTo(expectCount);
    }

}