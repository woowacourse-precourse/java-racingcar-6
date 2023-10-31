package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private static final RacingGame rg = new RacingGame();

    @Test
    void 값_비교_후_전진() {

        //given
        Car car = new Car("car");
        int num = 4;

        //when
        rg.forwardOrStop(car, num);

        //then
        assertThat(car.getMove()).isEqualTo(1);
    }

    @Test
    void 값_비교_후_정지() {

        //given
        Car car = new Car("car");
        int num = 3;

        //when
        rg.forwardOrStop(car, num);

        //then
        assertThat(car.getMove()).isEqualTo(0);
    }

    @Test
    void 최대_전진_자동차() {

        //given
        List<Car> cars = new ArrayList<>();

        Car car1 = getCar(cars, "car1");
        Car car2 = getCar(cars, "car2");
        Car car3 = getCar(cars, "car3");

        moveForward(car1, 1);
        moveForward(car2, 3);
        moveForward(car3, 3);

        //when
        List<String> maxMoveCar = rg.getMaxMoveCar(cars);

        //then
        assertThat(maxMoveCar.size()).isEqualTo(2);
        assertThat(maxMoveCar.toString()).contains("car2", "car3");
    }

    private Car getCar(List<Car> cars, String name) {
        Car car = new Car(name);
        cars.add(car);
        return car;
    }

    private void moveForward(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.forward();
        }
    }
}
