package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {

    private CarList cars;
    private Car pobiCar;
    private Car woniCar;

    @BeforeEach
    public void setUp() {
        cars = new CarList("pobi,woni,jun");

        pobiCar = cars.getCars().get(0);
        woniCar = cars.getCars().get(1);

        cars.moveCarWhenNumberFourOrAbove(pobiCar, 4);
        cars.moveCarWhenNumberFourOrAbove(pobiCar, 5);
        cars.moveCarWhenNumberFourOrAbove(pobiCar, 6);

        cars.moveCarWhenNumberFourOrAbove(woniCar, 4);
        cars.moveCarWhenNumberFourOrAbove(woniCar, 5);
    }

    @Test
    @DisplayName("car 한대 움직이는 조건 만족하는지 test")
    public void moveCarWhenNumberFourOrAboveTest() {

        Car junCar = cars.getCars().get(2);

        assertThat(junCar.getPosition()).isEqualTo(0);

        cars.moveCarWhenNumberFourOrAbove(junCar, 0);
        assertThat(junCar.getPosition()).isEqualTo(0);

        cars.moveCarWhenNumberFourOrAbove(junCar, 3);
        assertThat(junCar.getPosition()).isEqualTo(0);

        cars.moveCarWhenNumberFourOrAbove(junCar, 4);
        assertThat(junCar.getPosition()).isEqualTo(1);

        cars.moveCarWhenNumberFourOrAbove(junCar, 9);
        assertThat(junCar.getPosition()).isEqualTo(2);
    }

}
