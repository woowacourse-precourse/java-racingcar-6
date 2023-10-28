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
    void 회수에_대한_예외처리_음수() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.carName("-2");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 회수에_대한_예외처리_제로() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.carName("0");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 회수에_대한_예외처리_문자() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.carName("l");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 회수에_대한_예외처리_공백() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.carName("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
