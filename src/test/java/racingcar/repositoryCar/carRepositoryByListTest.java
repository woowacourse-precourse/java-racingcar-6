package racingcar.repositoryCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.controller.checkWinner.checkWinnerByMove;
import racingcar.controller.random.randomOneToNine;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.*;

class carRepositoryByListTest {
    CarRepository carRepository = new carRepositoryByList(new randomOneToNine(), new checkWinnerByMove());

    @Test
    public void save_확인(){
        Car car = new Car("yusun");
        car.move();

        carRepository.save(car);

        Assertions.assertThat(carRepository.getCarList().get(0).getName()).isEqualTo("yusun");
    }
}