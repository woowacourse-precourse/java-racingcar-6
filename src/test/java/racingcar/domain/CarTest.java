package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("tiger");
    }

    @Test
    @DisplayName("자동차 이름 반환 테스트")
    void testGetCarName() {
        assertThat(car.getName()).isEqualTo("tiger");
    }

    @Test
    @DisplayName("파라미터가 4미만이면 이동하지 않는지 테스트")
    void testCarDontMoveParameterIsLessThanFour() {
        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("파라미터가 4이상이면 한칸 이동 테스트")
    void testCarMoveOneDistanceParameterIsGREATERThanOrEqualFour() {
        car.move(6);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
