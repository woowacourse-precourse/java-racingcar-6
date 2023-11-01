package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.position.Position;
import racingcar.domain.power.DefaultPowerGenerator;
import racingcar.dto.CarStatusDto;

class WinnerSelectionServiceTest {

    @DisplayName("단일 우승자를 판단할 수 있다.")
    @Test
    void testSelectWinnersWithSingleWinner() {
        WinnerSelectionService winnerSelectionService = new WinnerSelectionService();
        Car car1 = new Car(new CarName("car1"), new Position(3), new DefaultPowerGenerator());
        Car car2 = new Car(new CarName("car2"), new Position(5), new DefaultPowerGenerator());
        Car car3 = new Car(new CarName("car3"), new Position(2), new DefaultPowerGenerator());
        List<Car> carList = Arrays.asList(car1, car2, car3);
        Cars cars = Cars.createFrom(carList);
        List<CarStatusDto> carStatusDtos = winnerSelectionService.selectWinners(cars);
        assertEquals(1, carStatusDtos.size());
        assertEquals("car2", carStatusDtos.get(0).getCarName().toString());
    }

    @DisplayName("복수 우승자를 판단할 수 있다.")
    @Test
    void testSelectWinnersWithMultipleWinner() {
        WinnerSelectionService winnerSelectionService = new WinnerSelectionService();
        Car car1 = new Car(new CarName("car1"), new Position(5), new DefaultPowerGenerator());
        Car car2 = new Car(new CarName("car2"), new Position(5), new DefaultPowerGenerator());
        Car car3 = new Car(new CarName("car3"), new Position(2), new DefaultPowerGenerator());
        List<Car> carList = Arrays.asList(car1, car2, car3);
        Cars cars = Cars.createFrom(carList);
        List<CarStatusDto> carStatusDtos = winnerSelectionService.selectWinners(cars);
        assertEquals(2, carStatusDtos.size());
        assertEquals("car1", carStatusDtos.get(0).getCarName().toString());
        assertEquals("car2", carStatusDtos.get(1).getCarName().toString());

    }


}