package racingcar.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @Test
    void 이름에_대한_예외처리_길이() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.carName("pobi,woonii,jun");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름에_대한_예외처리_공백() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.carName("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름에_대한_예외처리_이름_하나() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.carName("pobi");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름에_대한_예외처리_중복() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.carName("pobi,pobi,wooni");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름에_대한_예외처리_빈_이름() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.carName("pobi,,wooni");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
