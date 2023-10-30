package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.vo.CarId;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @BeforeEach
    void beforeEach() {
//         정적 변수 Count, Id 초기화
//         테스트는 독립적이어야 한다.
        Car.resetId();
    }

    @Test
    void Car_객체_생성_성공() {
        Car car = new Car("pobi");
        Assertions.assertThat(car.getName()).isEqualTo("pobi");
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
        Assertions.assertThat(car.getClass()).isEqualTo(Car.class);
    }

    @Test
    void Car_객체_성생시_정적변수_ID_증가하면서_초기화() throws NoSuchFieldException, IllegalAccessException {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        Car spyCar1 = Mockito.spy(car1);
        Car spyCar2 = Mockito.spy(car2);

        // Reflection을 사용하여 private 필드인 id의 값을 가져옵니다.
        java.lang.reflect.Field field = Car.class.getDeclaredField("id");
        field.setAccessible(true);
        CarId id1 = (CarId) field.get(spyCar1);
        CarId id2 = (CarId) field.get(spyCar2);

        // id 값을 검증합니다.
        assertThat(0).isEqualTo(id1.value());
        assertThat(1).isEqualTo(id2.value());
    }

    @Test
    void forward_전진시_위치_증가() {
        Car car = new Car("car");
        Assertions.assertThat(car.getPosition()).isEqualTo(0);

        int forwardCount = 1;
        car.forward(forwardCount);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);

        car.forward(forwardCount);
        car.forward(forwardCount);
        car.forward(forwardCount);
        Assertions.assertThat(car.getPosition()).isEqualTo(4);
    }

    @Test
    void forward_후진시_제자리() {
        Car car = new Car("car");
        Assertions.assertThat(car.getPosition()).isEqualTo(0);

        int forwardCount = -1;
        car.forward(forwardCount);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);

        car.forward(forwardCount);
        car.forward(forwardCount);
        car.forward(forwardCount);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
