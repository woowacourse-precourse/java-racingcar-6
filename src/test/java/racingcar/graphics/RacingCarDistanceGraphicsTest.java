package racingcar.graphics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.display.graphics.RacingCarDistanceGraphics;
import racingcar.domain.entity.Car;

class RacingCarDistanceGraphicsTest {

    @Test
    @DisplayName("자동차 거리 1당 '-'을 연속해서 저장한다.")
    void updateCarGraphicsBasedOnDistance() {
        // given
        String car1Name = "pobi";
        String car2Name = "won";
        Car car1 = Car.create(car1Name);
        Car car2 = Car.create(car2Name);
        List<Car> cars = List.of(car1, car2);

        RacingCarDistanceGraphics racingCarDistanceGraphics = new RacingCarDistanceGraphics(cars);

        car1.changeDistance(1);
        car2.changeDistance(2);
        List<Car> updateCars = List.of(car1, car2);

        // when
        Map<String, String> carGraphics = racingCarDistanceGraphics.updateCarGraphicsBasedOnDistance(updateCars);

        // then
        assertAll(
                () -> assertThat(carGraphics.get(car1Name)).isEqualTo("-"),
                () -> assertThat(carGraphics.get(car2Name)).isEqualTo("--")
        );
    }
}