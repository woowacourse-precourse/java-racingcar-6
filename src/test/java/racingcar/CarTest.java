package racingcar;

import data.Car;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class CarTest {
    @Test
    void 올바른_이름_테스트(){
        String name = "cys";
        Car car = new Car(name);

        assertThat(car.getName()).contains("cys");
    }

    @Test
    void 잘못된_이름_테스트(){
        String name = "cyscyscys";
        assertThatThrownBy(()->new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Name can be longer than 5");
    }
}
