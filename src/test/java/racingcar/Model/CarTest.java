package racingcar.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("차 이름 가져오기 결과 테스트")
    void getNameTest() {
        Car car = new Car("pobi");

        AssertionsForClassTypes.assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void forwardCarPosition() {
        Car car = new Car("pobi");

        car.forwardCarPosition();

        AssertionsForClassTypes.assertThat(car.getCarPosition()).isEqualTo(1);
    }
}