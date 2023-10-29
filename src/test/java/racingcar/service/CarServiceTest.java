package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

class CarServiceTest {

    @Test
    @DisplayName("전진 기능 테스트")
    void forward() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        CarService carService = new CarService();
        CarRepository carRepository = new CarRepository();

        // when
        carRepository.save(pobi);
        carRepository.save(woni);
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(4,9);
            carService.updateCarScore(car, randomNum);
        }
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0,3);
            carService.updateCarScore(car, randomNum);
        }

        // then
        assertThat(pobi.getScore()).isEqualTo(1);
        assertThat(woni.getScore()).isEqualTo(1);
    }

}