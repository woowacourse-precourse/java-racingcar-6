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
    private static List<List<Object>> oneFastestCarStatus;
    private static List<List<Object>> coFastestCarsStatus;

    @BeforeAll
    static void setCarsInfo() {
        carList = new ArrayList<>();
        racingCars = new Cars();
        carsStatus = new ArrayList<>();
        oneFastestCarStatus = Arrays.asList(
                Arrays.asList("pobi", 5),
                Arrays.asList("inss", 2),
                Arrays.asList("R8", 4)
        );
        coFastestCarsStatus = Arrays.asList(
                Arrays.asList("pobi", 5),
                Arrays.asList("inss", 2),
                Arrays.asList("R8", 4),
                Arrays.asList("turtle", 5)
        );
        carsStatus = oneFastestCarStatus;
    }

    @BeforeEach
    void resetCars() {
        carList.clear();
        racingCars.provideRacingCars().clear();
        switchCarStatus(carsStatus);
        for (List<Object> carStatus : carsStatus) {
            Car car = new Car((String) carStatus.get(0));
            for (int moveTimes = 0; moveTimes < (Integer) carStatus.get(1); moveTimes++) {
                car.calculatePosition(true);
            }
            carList.add(car);
            racingCars.addCar(car);
        }
    }

    void switchCarStatus(List<List<Object>> carsStatus) {
        CarsTest.carsStatus = carsStatus;
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

    @DisplayName("우승 자동차 복수 판별 테스트 - 단수 데이터 - 성공")
    @Test
    void isCoFastestCarTest() {
        racingCars.isCoFastestCars();

        assertThat(racingCars.isCoFastestCars()).isEqualTo(false);
    }

    @DisplayName("우승 자동차 복수 판별 테스트 - 복수 데이터 - 성공")
    @Test
    void isCoFastestCarsTest() {
        switchCarStatus(coFastestCarsStatus);
        resetCars();
        switchCarStatus(oneFastestCarStatus);
        racingCars.isCoFastestCars();

        assertThat(racingCars.isCoFastestCars()).isEqualTo(true);
    }
}
