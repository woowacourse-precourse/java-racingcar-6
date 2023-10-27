package study;

import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 입력_이름과_생성된_자동차_이름_비교() {
        String name = "pobi";
        Car car = CarFactory.createCars(List.of(name)).stream().findFirst().orElse(null);

        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 조건별_전진_가능_여부_판단() {

        int numberCondition1 = 3;
        int numberCondition2 = 4;
        Car car = new Car("pobi");

        assertThat(car.getForwardDistanceBetweenStartLine()).isEqualTo(0);

        car.tryForwardByCondition(numberCondition1);
        assertThat(car.getForwardDistanceBetweenStartLine()).isEqualTo(0);

        car.tryForwardByCondition(numberCondition2);
        assertThat(car.getForwardDistanceBetweenStartLine()).isEqualTo(1);
    }

}
