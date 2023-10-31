package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;


public class CarTest {

    @DisplayName("차는 0~9 숫자 중 4 이상이 나오면 전진한다.")
    @Test
    void 자동차_전진_성공() {
        //given
        Car car = new Car("userA") {
            @Override
            protected int getRandomNumber() {
                return 4;
            }

        };

        //when
        car.tryMoveForward();

        //then
        assertThat(car.getDistance()).isEqualTo(1);

    }

    @DisplayName("차는 0~9 숫자 중 4 미만이 나오면 전진하지 않는다.")
    @Test
    void 자동차_전진_실패() {
        //given
        Car car = new Car("userA") {
            @Override
            protected int getRandomNumber() {
                return 3;
            }
        };

        //when
        car.tryMoveForward();

        //then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("차의 이름의 길이는 1~5 범위에 속해야 한다.")
    @Test
    void 자동차_이름_초기화() {
        //given
        String validName = "pobi";

        //when
        Car car = new Car(validName);

        //then
        assertThat(car.getName()).isEqualTo(validName);
    }

    @DisplayName("차는 5보다 긴 이름을 가질 수 없다.")
    @Test
    void 자동차_이름_길이_초과() {
        //given
        String unvalidName = "chanho";

        //when,then
        assertThatThrownBy(() -> new Car(unvalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5글자 이하여야 됩니다.");
    }

    @DisplayName("차의 이름이 비어있으면 안된다.")
    @Test
    void 자동차_이름_공백() {
        //given
        String unvalidName = "";

        //when,then
        assertThatThrownBy(() -> new Car(unvalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 비어있습니다.");
    }


}
