package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("5글자 초과의 이름의 자동차 생성 시 에러 발생 테스트")
    public void testCarNameGreaterThanFive() {
        String name = "superman";

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    @DisplayName("파라미터가 4미만이면 이동하지 않는지 테스트")
    public void testCarDontMoveParameterIsLessThanFour() {
        Car car = new Car("leon");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("파라미터가 4이상이면 한칸 이동 테스트")
    public void testCarMoveOneDistanceParameterIsGREATERThanOrEqualFour() {
        Car car = new Car("leon");

        car.move(6);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
