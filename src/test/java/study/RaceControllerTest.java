package study;

import racingcar.domain.CarManager;
import racingcar.Controller.RaceController;
import racingcar.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceControllerTest {

    private RaceController raceController;
    private CarManager carManager;

    @BeforeEach
    void setUp() {
        raceController = new RaceController();
        carManager = new CarManager();
    }

    @Test
    void 차_움직이기() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        carManager.addCar(car1);
        carManager.addCar(car2);
        carManager.addCar(car3);

        raceController.setCarList(carManager);
        raceController.raceStart();

        List<Car> carList = carManager.getCarList();

        for (Car car : carList) {
            assertTrue(car.getCurrentPosition().endsWith("-") || car.getCurrentPosition().isEmpty(), "차량 위치가 정상적으로 표시되어야 합니다.");
        }
    }

    @Test
    void 우승자_출력() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        carManager.addCar(car1);
        carManager.addCar(car2);
        carManager.addCar(car3);

        raceController.setCarList(carManager);
        raceController.raceStart();

        List<String> winners = raceController.getWinner();

        for (Car car : carManager.getCarList()) {
            if (car.getCurrentPosition().length() == winners.get(0).length()) {
                assertEquals(car.getName(), winners.get(0));
            }
        }
    }
}