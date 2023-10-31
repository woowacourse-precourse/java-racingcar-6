package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    List<Car> carList = new ArrayList<>();
    List<List<Object>> carsStatus = Arrays.asList(
            Arrays.asList("pobi", 5),
            Arrays.asList("inss", 2),
            Arrays.asList("R8", 4)
    );

    @BeforeEach
    void initCars() {
        for (List<Object> carStatus : carsStatus) {
            Car car = new Car((String) carStatus.get(0));
            for (int moveTimes = 0; moveTimes < (Integer) carStatus.get(1); moveTimes++) {
                car.calculatePosition(true);
            }
            carList.add(car);
        }
    }

    @DisplayName("각 자동차 저장/반환 테스트 - 정상 데이터 - 성공")
    @Test
    void addCarsTest() {
        Cars cars = new Cars();
        for (Car car : carList) {
            cars.addCar(car);
        }
        assertThat(cars.provideRacingCars()).isEqualTo(carList);
    }

    @DisplayName("자동차 총 대수 반환 테스트 - 정상 데이터 - 성공")
    @Test
    void getNumberOfCarsTest() {
        Cars cars = new Cars();
        addCar(cars);
        assertThat(cars.getNumberOfCars()).isEqualTo(carList.size());
    }

    @DisplayName("각 자동차 위치정보 적용 테스트 - 정상 데이터 - 성공")
    @Test
    void updateCarsPositionTest() {
        Cars cars = new Cars();
        addCar(cars);
        cars.updateCarsPosition(Arrays.asList(true, true, true));

        for (int i = 0; i < cars.getNumberOfCars(); i++) {
            assertThat(cars.provideRacingCars().get(i).provideCarStatus().get("position"))
                    .isEqualTo((Integer)carsStatus.get(i).get(1) + 1);
        }
    }

    private void addCar(Cars cars) {
        for (Car car : carList) {
            cars.addCar(car);
        }
    }
}
