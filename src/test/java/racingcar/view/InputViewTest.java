package racingcar.view;


import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Car;

class InputViewTest {

    @Test
    void responseCarNames() {
        // Given
        String[] carNames = {"car1", " car2 ", "car3"};

        // When
        List<Car> cars = InputView.responseCarNames(carNames);

        // Then
        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
        assertEquals("car3", cars.get(2).getName());
    }

    @Test
    void putCars() {
        // Given
        List<String> trimmedCarNames = Arrays.asList("car1", "car2", "car3");

        // When
        List<Car> cars = InputView.putCars(trimmedCarNames);

        // Then
        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
        assertEquals("car3", cars.get(2).getName());
    }

    @Test
    void doTrim() {
        // Given
        String[] carNames = {"car1", " car2 ", "car3"};

        // When
        List<String> trimmedCarNames = InputView.doTrim(carNames);

        // Then
        assertEquals(Arrays.asList("car1", "car2", "car3"), trimmedCarNames);
    }

}