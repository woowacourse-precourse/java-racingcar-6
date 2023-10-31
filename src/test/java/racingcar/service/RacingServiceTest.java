package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

public class RacingServiceTest {

    RacingService racingService = new RacingService();

    @BeforeEach
    void 문자열이_입력되면_자동차_이름으로_저장() {
        String userInput = "pobi,woni,jun";
        racingService.generateCars(userInput);

        List<Car> cars = racingService.getAllCars();
        Assertions.assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 난수를_생성해서_전진_혹은_멈춤() {
        racingService.playGame();

        List<Car> cars = racingService.getAllCars();
        for (Car car : cars) {
            int carDistance = car.getCarDistance();
            Assertions.assertThat(carDistance).isBetween(0,1);
        }
    }

    @Test
    void 모든_차들의_진행거리_출력() {
        List<Car> allCars = racingService.getAllCars();
        for (Car car : allCars) {
            car.forward();
            car.forward();
        }
        racingService.printAllCarsDistance();
    }

    @Test
    void 최종_우승자_선발() {
        racingService.selectWinner();
    }
}
