package racingcar.domian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.domain.Car;

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
            int id1 = (int) field.get(spyCar1);
            int id2 = (int) field.get(spyCar2);

            // id 값을 검증합니다.
            assertThat(0).isEqualTo(id1);
            assertThat(1).isEqualTo(id2);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void 차_객체_생성시_이름_있음() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        // 이 또한 리플렉션을 이용해서 get() 없이 해도 되지만, 아래에 안한 이유 있음.
//        성공하는 테스트, 하지만 getName() 매서드 지웠다.
//        assertThat(car1.getName()).isEqualTo("pobi");
//        assertThat(car2.getName()).isEqualTo("woni");
    }


    /**
     * void 차_전진시_전진갯수_증가()
     *
     * 사용하지 않는 get() 매서드를 메인문에 만들지 않기 위해, 리플렉션을 이용해 테스트 코드를 작성해봤는데
     * 리플렉션을 남발하면 메모리 측변과 보안관점에서 좋지 않다는 글이 있었다.
     * 우선 이미 코드를 썼으니 남겨두고 코드 구현 다하고 공부해 봐야겠다.
     *
     * 해결 -> private 멤버 변수를 테스트 하지 말고, 전진을 하는 행위를 테스트 하면 되는 것 이었다.
     *  처음부터 테스트 코드에 대한 시선을 잘못 잡은거 같다.
     *
     *  우선 코드는 남겨논다.
     *
     */
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
