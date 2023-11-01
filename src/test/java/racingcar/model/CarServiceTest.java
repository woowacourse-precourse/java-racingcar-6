package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarServiceTest {

    private final CarService carService = new CarService(new CarRepository());

    @Test
    void getCarNameHasLongestDistance_메서드로_가장_이동거리가_많은_자동차_이름_저장_단독우승() {
        // Given
        CarCollection carCollection = new CarCollection(Arrays.asList(
                new Car("car1", 3),
                new Car("car2", 5),
                new Car("car3", 2)
        ));
        carService.saveAllCars(carCollection);

        // When
        List<String> winnerNames = carService.getCarNameHasLongestDistance();

        // Then
        assertThat(winnerNames).containsExactly("car2");
    }

    @Test
    void getCarNameHasLongestDistance_메서드로_가장_이동거리가_많은_자동차_이름_저장_공동우승(){
        // Given
        CarCollection carCollection = new CarCollection(Arrays.asList(
                new Car("car1", 3),
                new Car("car2", 5),
                new Car("car3", 5)
        ));
        carService.saveAllCars(carCollection);

        // When
        List<String> winnerNames = carService.getCarNameHasLongestDistance();

        // Then
        assertThat(winnerNames).containsExactly("car2","car3");
    }
}
