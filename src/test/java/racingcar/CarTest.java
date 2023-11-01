package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    void move() {
        String name = "move_test";
        int total = 10000;
        double answer = 0.6, error = 0.01;

        Car car = new Car(name);
        for (int i = 0; i < total; i++) {
            car.move();
        }
        int cnt = car.getDistance();

        // 이동 확률이 0.59 ~ 0.61이면 통과
        assertThat(Math.abs((double) cnt / total - answer)).isLessThan(error);
    }

    @Test
    void getStatus_이동_거리가_0() {
        String name = "Hello";
        int distance = 0;
        String answer = "Hello : ";

        Car car = new Car(name, distance);
        String result = car.getStatus();
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void getStatus_이동_거리가_1이상() {
        String name = "World";
        int distance = 3;
        String answer = "World : ---";

        Car car = new Car(name, distance);
        String result = car.getStatus();
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void parseCars_이름이_1개_이상() {
        String string = "cpp,java,js";
        List<Car> result = Car.parseCars(string);

        assertThat(result).containsExactly(new Car("cpp"), new Car("java"), new Car("js"));
    }

    @Test
    void parseCars_이름이_없음() {
        String string = "";
        List<Car> result = Car.parseCars(string);

        assertThat(result).containsExactly(new Car(""));
    }

    @Test
    void parseCars_5글자_초과_이름() {
        String string = "cpp,java,js,python";
        assertThatThrownBy(() -> Car.parseCars(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OutputMessage.ERROR_CAR_NAME_LENGTH_LIMIT_OVER);
    }

    @Test
    void testEquals() {
        Car car = new Car("car_name", 1);
        Car car2 = new Car("car_name", 1);
        Car car3 = new Car("this_is_not_car", 1);
        Car car4 = new Car("car_name", 2);

        assertThat(car).isEqualTo(car2);
        assertThat(car).isNotEqualTo(car3);
        assertThat(car).isNotEqualTo(car4);
    }
}