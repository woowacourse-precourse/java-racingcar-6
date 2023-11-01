package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 유효한_길이의_자동차_이름_들어온_경우() {
        String name = "yen";
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getNumberOfMove()).isEqualTo(0);
    }

    @Test
    void 빈_문자열이_자동차_이름으로_들어온_경우() {
        String empty = "";

        assertThatThrownBy(() -> new Car(empty))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 전진_확인() {
        Car car = new Car("yen");
        car.moveFoward(4);
        int result = car.getNumberOfMove();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 전진_안_하는_것_확인() {
        Car car = new Car("yen");
        car.moveFoward(1);
        int result = car.getNumberOfMove();

        assertThat(result).isEqualTo(0);
    }
}
