package racingcar.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    private static List<Car> carList;
    private static Cars racingCars;
    private static List<List<Object>> carsStatus;

    @BeforeAll
    static void setCarsInfo() {
        carList = new ArrayList<>();
        racingCars = new Cars();
        carsStatus = Arrays.asList(
                Arrays.asList("pobi", 5),
                Arrays.asList("inss", 2),
                Arrays.asList("R8", 4)
        );
    }

    @BeforeEach
    void resetCars() {
        carList.clear();
        racingCars.provideRacingCars().clear();
        for (List<Object> carStatus : carsStatus) {
            Car car = new Car((String) carStatus.get(0));
            for (int moveTimes = 0; moveTimes < (Integer) carStatus.get(1); moveTimes++) {
                car.calculatePosition(true);
            }
            carList.add(car);
            racingCars.addCar(car);
        }
    }

    @DisplayName("각 자동차 저장/반환 테스트 - 정상 데이터 - 성공")
    @Test
    void addCarsTest() {
        racingCars.provideRacingCars().clear();
        for (Car car : carList) {
            racingCars.addCar(car);
        }
        assertThat(racingCars.provideRacingCars()).isEqualTo(carList);
    }

    @DisplayName("자동차 총 대수 반환 테스트 - 정상 데이터 - 성공")
    @Test
    void getNumberOfCarsTest() {
        assertThat(racingCars.getNumberOfCars()).isEqualTo(carList.size());
    }

    @DisplayName("각 자동차 위치정보 적용 테스트 - 정상 데이터 - 성공")
    @Test
    void updateCarsPositionTest() {
        racingCars.updateCarsPosition(Arrays.asList(true, true, true));

        for (int i = 0; i < racingCars.getNumberOfCars(); i++) {
            assertThat(racingCars.provideRacingCars().get(i).provideCarStatus().get("position"))
                    .isEqualTo((Integer)carsStatus.get(i).get(1) + 1);
        }
    }
}
