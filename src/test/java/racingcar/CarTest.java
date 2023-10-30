package racingcar;

import domain.Car;
import domain.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarTest {

    @Test
    void 자동차를_전진시키는_기능_테스트() {
        //given
        String userInput = "yoon,su";
        String[] carNames = userInput.split(",");
        Cars cars = new Cars(carNames);

        List<Car> getCars = cars.getCars();
        Car yoonCar = getCars.get(0);

        //when
        Car moveCar = yoonCar.moveAhead();

        //then
        Assertions.assertThat(moveCar.getProgress()).isEqualTo(1);
    }
}
