package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;

@DisplayName("자동차 생성 서비스 테스트")
class CarFactoryServiceTest {

    @DisplayName("이름의 배열로 생성한 자동차들의 사이즈가 이름의 배열 사이즈와 같다")
    @Test
    void testPrepareRacingCars() {
        CarFactoryService carFactoryService = new CarFactoryService();
        List<CarName> carNames = Arrays.asList(
                new CarName("Car1"),
                new CarName("Car2"),
                new CarName("Car3")
        );
        Cars racingCars = carFactoryService.prepareRacingCars(carNames);
        assertEquals(carNames.size(), racingCars.getCurrentRoundSnapshot().getRoundResult().size());
    }
}