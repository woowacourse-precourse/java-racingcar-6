package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarStorage;

public class CarGameServiceTest {

    CarGameService gameService;
    String[] carNames = {"pobi", "jo", "Kim"};

    @BeforeEach
    void before() {
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .toList();
        CarStorage storage = new CarStorage(cars);
        gameService = new RacingCarGameService(storage);
    }

    @Test
    @DisplayName("자동차를 생성하고, 잘 저장되어 있는지 확인")
    void makeAndStoreCarTest() {
        List<Car> cars = gameService.getDuplicatedCars();
        List<String> carNameList = cars.stream()
                .map(Car::getName)
                .toList();
        List<String> originalCarNameList = Arrays.asList(carNames);

        assertThat(carNameList).isEqualTo(originalCarNameList);
    }

    @Test
    @DisplayName("입력 값이 4 이상일 때, 자동차 이동거리가 갱신되는지 확인")
    void updateCarTest() {
        int[] numbers = new int[]{4,5,6};
        List<Integer> boxedNumbers = Arrays.stream(numbers)
                .boxed()
                .toList();
        gameService.updateCar(boxedNumbers);

        List<Car> cars = gameService.getDuplicatedCars();

        assertThat(cars.get(0).getDistance()).isEqualTo(1);
        assertThat(cars.get(1).getDistance()).isEqualTo(1);
        assertThat(cars.get(2).getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 값이 4 미만일 때, 자동차 이동거리가 갱신되지 않는지 확인")
    void notUpdateCarTest() {
        int[] numbers = new int[]{1,2,3};
        List<Integer> boxedNumbers = Arrays.stream(numbers)
                .boxed()
                .toList();
        gameService.updateCar(boxedNumbers);

        List<Car> cars = gameService.getDuplicatedCars();

        assertThat(cars.get(0).getDistance()).isEqualTo(0);
        assertThat(cars.get(1).getDistance()).isEqualTo(0);
        assertThat(cars.get(2).getDistance()).isEqualTo(0);
    }

}
