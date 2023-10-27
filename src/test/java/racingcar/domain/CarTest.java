package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    void 자동차_전진_확인(){
        Car car = new Car("test");
        Integer position = car.getPosition();

        for (int i=0; i < 3; i++) {
            car.moveForward();
        }

        int result = car.getPosition();

        assertThat(position).isEqualTo(0);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 자동차_이름_확인(){
        Car car = new Car("test");
        String name = car.getName();

        assertThat(name).isEqualTo("test");
    }
}