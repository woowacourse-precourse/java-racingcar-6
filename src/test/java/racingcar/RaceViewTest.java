package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarDto;

class RaceViewTest {

    @Test
    @DisplayName("한 번의 이동 이후, 자동차들의 현재 상태를 출력합니다.")
    void printCarsStatus() {
        // GIVEN
        List<Car> cars = new ArrayList<>();
        cars.add(Car.createCar("pobi", 2));
        cars.add(Car.createCar("woni", 4));
        cars.add(Car.createCar("jun", 3));
        String expectedStatus = "pobi : --\n"
                + "woni : ----\n"
                + "jun : ---\n";

        // WHEN
        String actualStatus = RaceView.printCarsStatus(cars);

        // THEN
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    @DisplayName("우승자에 대한 결과를 츨력합니다.")
    void printWinners() {
        // GIVEN
        CarDto winnerCarDto = new CarDto("pobi, woni");
        String expectedResult = "최종 우승자 : pobi, woni";

        // WHEN
        String actualResult = RaceView.printWinners(winnerCarDto);

        // THEN
        assertEquals(expectedResult, actualResult);
    }
}