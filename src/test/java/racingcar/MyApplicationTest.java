package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.Arrays;
import java.util.List;

class MyApplicationTest {
    @Test
    void Car_class_method_test(){
        Application.Car car = new Application.Car("test");

        car.tryMove(3);
        assertThat(car.getPosition()).isEqualTo(0); // 4 미만의 숫자가 들어오면 안 움직임

        car.tryMove(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void isException_method_test(){
        String nameOverFive = "abcdef";

        //이름 길이가 5 초과하면 예외 발생
        assertThatThrownBy(() -> Application.isException(nameOverFive))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void getMaxPosition_method_test(){
        List<Application.Car> cars = Arrays.asList(new Application.Car("a"), new Application.Car("b"), new Application.Car("c"));

        cars.get(0).tryMove(4);  // a: 1
        cars.get(1).tryMove(4);  // b: 1
        cars.get(1).tryMove(4);  // b: 2
        cars.get(2).tryMove(4);  // c: 1

        //가장 많이 움직인 b의 위치 반환 확인
        assertThat(Application.getMaxPosition(cars)).isEqualTo(2);
    }
}