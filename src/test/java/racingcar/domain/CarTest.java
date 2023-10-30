package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @BeforeEach
    public void resetIdAutoIncrement() throws Exception {
        // 리플렉션을 이용해서, 각 테스트마다 정적 변수 idAutoIncrement 0으로 초기화
        Field field = Car.class.getDeclaredField("idAutoIncrement");
        field.setAccessible(true);
        field.set(null, 0L);
    }

    @Test
    public void Car_객체_성생시_정적변수_ID_증가하면서_초기화1() {
        // Car 객체를 생성
        Car car1 = new Car("Car1");
        assertEquals(0L, car1.getId());

        Car car2 = new Car("Car2");
        assertEquals(1L, car2.getId());
    }

    @Test
    public void Car_객체_성생시_정적변수_ID_증가하면서_초기화2() {
        // Car 객체를 생성
        Car car1 = new Car("Car1");
        assertEquals(0L, car1.getId());

        Car car2 = new Car("Car2");
        assertEquals(1L, car2.getId());
    }

    @Test
    void Car_객체_생성_성공() {
        Car car = new Car("pobi");
        Assertions.assertThat(car.getName()).isEqualTo("pobi");
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
        Assertions.assertThat(car.getClass()).isEqualTo(Car.class);
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
