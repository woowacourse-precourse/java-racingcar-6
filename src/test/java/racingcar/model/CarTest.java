package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 자동차_초기위치_0이아니면_예외(){
        Car car = new Car("junki");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 파워_4이상_전진(){
        Car car = new Car("junki");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 파워_3이하_정지(){
        Car car = new Car("junki");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이름_5자_초과_예외(){
        assertThatThrownBy(() -> new Car("longname"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_Null_예외(){
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
