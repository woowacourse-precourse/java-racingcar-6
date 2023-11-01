package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    @Test
    void 이름에_대한_예외_처리_5자초과() {
        assertThatThrownBy(() -> new Car("over5test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름에_대한_예외_처리_입력값이_비어있을때() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전진_조건_성공(){
        Car car = new Car("test");
        assertThat(car.canMove(5)).isEqualTo(true);
    }

    @Test
    void 전진_조건_실패(){
        Car car = new Car("test");
        assertThat(car.canMove(3)).isEqualTo(false);
    }

    @Test
    void 전진() {
        Car car = new Car("test");
        car.move();
        car.move();
        assertThat(car.getDistance()).isEqualTo(2);
    }
}