package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarServiceTest {
    private CarService carService;

    @BeforeEach
    void setUp() {
        CarRepository carRepository = new CarRepository();
        carService = new CarService(carRepository);
    }

    @Test
    void 컬렉션_저장되는지_확인() {
        // Given
        CarCollection cars = new CarCollection(Arrays.asList(
                new Car("Car1",0),
                new Car("Car2",0),
                new Car("Car3",0)
        ));

        // When
        carService.saveAllCars(cars);

        // Then
        CarCollection savedCars = carService.getAllCars();
        assertThat(savedCars).isEqualTo(cars);
    }

    @Test
    void 저장된_컬렉션을_불러오는지_확인() {
        // Given
        CarCollection cars = new CarCollection(Arrays.asList(
                new Car("Car1",0),
                new Car("Car2",0),
                new Car("Car3",0)
        ));
        carService.saveAllCars(cars);

        // When
        CarCollection savedCars = carService.getAllCars();

        // Then
        assertThat(savedCars).isEqualTo(cars);
    }

    @Test
    void 랜덤숫자가_범위안에_있는지() {
        int randomNumber = carService.getRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void 가장_이동거리가_많은_자동차_이름_저장_CASE_단독우승() {
        // Given
        CarCollection cars = new CarCollection(Arrays.asList(
                new Car("car1", 3),
                new Car("car2", 5),
                new Car("car3", 2)
        ));
        carService.saveAllCars(cars);

        // When
        List<String> winnerNames = carService.getCarNameHasLongestDistance();

        // Then
        assertThat(winnerNames).containsExactly("car2");
    }

    @Test
    void 가장_이동거리가_많은_자동차_이름_저장_CASE_공동우승(){
        // Given
        CarCollection cars = new CarCollection(Arrays.asList(
                new Car("car1", 3),
                new Car("car2", 5),
                new Car("car3", 5)
        ));
        carService.saveAllCars(cars);

        // When
        List<String> winnerNames = carService.getCarNameHasLongestDistance();

        // Then
        assertThat(winnerNames).containsExactly("car2","car3");
    }

}
