package racingcar.ModelTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;
import racingcar.Model.Cars;
import racingcar.Model.CarsFactory;

public class CarsFactoryTest {
    CarsFactory carsFactory;

    @BeforeEach
    @DisplayName("GameService 객체생성")
    public void getInstance() {
        carsFactory = new CarsFactory();
    }

    @Test
    @DisplayName("cars 객체생성 테스트")
    public void generateCarsTest() {
        String[] carNames = {"tico","damas","ray"};
        Cars resultCars = carsFactory.generateCars(carNames);
        List<Car> cars = resultCars.getCars();

        assertThat(cars.size()).isEqualTo(carNames.length);
        for (int i = 0; i < carNames.length; i++) {
            assertThat(cars.get(i).getCarName()).isEqualTo(carNames[i]);
        }
    }
}
