package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void Car_객체_정상적으로_생성() {
        String validName = "유효";
        Car car = new Car(validName);

        assertThat(car).isNotNull();
    }

    @Test
    void 이름이_유효하지_않을_때_Car_객체_생성_예외_발생() {
        String nullName = null;
        String tooShortName = "";
        String tooLongName = "유효하지않은이름";

        assertThatThrownBy(() -> new Car(nullName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");

        assertThatThrownBy(() -> new Car(tooShortName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");

        assertThatThrownBy(() -> new Car(tooLongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }

    @Test
    void Car_객체_전진_테스트() {
        Car car = new Car("test");
        Car expectedCarAfterMove = new Car("test");

        car.move(4);
        expectedCarAfterMove.move(4);

        assertThat(car.getProgressStatus()).isEqualTo(expectedCarAfterMove.getProgressStatus());
    }

    @Test
    void Car_객체_정지_테스트() {
        Car car = new Car("test");
        Car expectedCarAfterNotMoving = new Car("test");

        car.move(3);

        assertThat(car.getProgressStatus()).isEqualTo(expectedCarAfterNotMoving.getProgressStatus());
    }

}
