package racingcar.domain.car.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.domain.car.dao.CarRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {

    @Nested
    @DisplayName("Car 객체 저장 테스트")
    class saveCarsTest {

        @Test
        @DisplayName("성공적으로 Car 객체가 저장되어야 한다.")
        public void 성공적으로_Car_객체가_저장되어야_한다() {
            CarRepository carRepository = mock(CarRepository.class);
            CarService carService = new CarService(carRepository);
            List<String> cars = List.of("firstCar", "secondCar", "thirdCar");

            carService.saveCars(cars);

            verify(carRepository, times(3)).save(any());
        }
    }

}
