package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @BeforeEach
    void beforeEach() {
//         정적 변수 Count, Id 초기화
//         테스트는 독립적이어야 한다.
        Car.resetId();
    }

    @Test
    void 차_객체_성생시_정적변수_ID_증가하면서_초기화() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        Car spyCar1 = Mockito.spy(car1);
        Car spyCar2 = Mockito.spy(car2);

        // Reflection을 사용하여 private 필드인 id의 값을 가져옵니다.
        try {
            java.lang.reflect.Field field = Car.class.getDeclaredField("id");
            field.setAccessible(true);
            long id1 = (long) field.get(spyCar1);
            long id2 = (long) field.get(spyCar2);

            // id 값을 검증합니다.
            assertThat(0).isEqualTo(id1);
            assertThat(1).isEqualTo(id2);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void 차_객체_생성시_이름_있음() {
        Car car = new Car("pobi");
        Assertions.assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 차_전진시_전진갯수_증가() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car("car");
        Field field = Car.class.getDeclaredField("forwardCount");
        field.setAccessible(true);

        int forwardCount = (int) field.get(car);
        assertThat(forwardCount).isEqualTo(0);

        car.forward();
        forwardCount = (int) field.get(car);
        assertThat(forwardCount).isEqualTo(1);

        car.forward();
        car.forward();
        forwardCount = (int) field.get(car);
        assertThat(forwardCount).isEqualTo(3);
    }
}
