package study;

import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
public class CarTest {

    @Test
    void 입력_이름과_생성된_자동차_이름_비교() {
        String name  = "pobi";
        Car car = CarFactory.createCars(List.of(name)).stream().findFirst().orElse(null);

        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(name);
    }

}
