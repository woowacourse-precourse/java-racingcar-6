package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {
    @Test
    void findWinner_메서드_사용시_같은_위치에_여러_대의_차가_있을_때_모두_반환() {
        CarList carList = new CarList();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        car1.drive(true);
        car2.drive(true);
        carList.addCar(car1);
        carList.addCar(car2);

        List<Car> winners = carList.findWinner(carList.getCarList());

        assertThat(winners).containsExactly(car1, car2);
    }
}
