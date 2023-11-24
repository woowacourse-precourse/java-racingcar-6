package service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarStatusDto;
import mock.MockNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import provider.TestProvider;
import racingcar.service.CarsService;

import java.util.List;

import static racingcar.domain.constant.CarConstant.INIT_POSITION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsServiceTest {

    private Cars testCars;

    private String testCarNames;

    private CarsService carsService;

    private MockNumberGenerator numberGenerator;

    @BeforeEach
    void init() {
        carsService = new CarsService();
        testCarNames = "pobi,crong,honux";
        numberGenerator = TestProvider.createMockNumberGenerator(false);
        testCars = TestProvider.createTestCars(testCarNames, numberGenerator);
    }

    @Test
    @DisplayName("사용자가 입력한 자동차의 이름만큼 자동차 리스트를 생성해야 한다.")
    void givenCarNames_thenReturnCars() {
        // when
        Cars carInfo = carsService.createCars(testCarNames, numberGenerator);
        List<Car> cars = carInfo.getCars();

        // then
        assertThat(cars.size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("모든 자동차의 초기 위치는 1이어야 한다.")
    void givenCars_whenInit_thenPositionIsOne() {
        // when
        int carCount = testCars.getCars().size();
        List<CarStatusDto> initStatus = carsService.getCarStatus(testCars);

        // then
        int normalPositionCarCount = (int) initStatus.stream()
                .filter(carRaceDto -> carRaceDto.getCarPosition() == INIT_POSITION.getValue())
                .count();

        assertThat(normalPositionCarCount)
                .isEqualTo(carCount);
    }
}