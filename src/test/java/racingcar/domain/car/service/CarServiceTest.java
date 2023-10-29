package racingcar.domain.car.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.domain.car.Car;
import racingcar.domain.car.dao.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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

    @Nested
    @DisplayName("Car 객체 읽기 테스트")
    class getCarsTest {

        @Test
        @DisplayName("성공적으로 승자를 읽어와야 한다")
        public void 성공적으로_승자를_읽어와야_한다() {
            CarRepository carRepository = mock(CarRepository.class);
            Car car = mock(Car.class);
            Car otherCar = mock(Car.class);
            CarService carService = new CarService(carRepository);

            when(car.getName()).thenReturn("carName");
            when(otherCar.getName()).thenReturn("otherCarName");
            when(carRepository.findCarWithMaxPosition()).thenReturn(List.of(car, otherCar));

            List<String> winner = carService.getWinner();

            assertThat(winner.size()).isEqualTo(2);
            assertThat(winner.get(0)).isEqualTo("carName");
            assertThat(winner.get(1)).isEqualTo("otherCarName");
        }
    }

    @Nested
    @DisplayName("자동차 경주 테스트")
    class RacingCarTest {

        @Test
        @DisplayName("레이싱 경주 후 성공적으로 Car List를 반환해야 한다")
        public void 레이싱_경주_후_성공적으로_Car_List를_반환해야_한다() {
            CarRepository carRepository = mock(CarRepository.class);
            CarService carService = new CarService(carRepository);
            Car car = mock(Car.class);
            Car otherCar = mock(Car.class);

            when(carRepository.findAll()).thenReturn(List.of(car, otherCar));
            when(car.race(anyInt())).thenReturn(car);
            when(otherCar.race(anyInt())).thenReturn(otherCar);

            List<Car> cars = carService.startRacingCar();

            verify(carRepository, times(1)).findAll();
            verify(car, times(1)).race(anyInt());
            verify(otherCar, times(1)).race(anyInt());

            assertThat(cars.size()).isEqualTo(2);
            assertThat(cars.get(0)).isEqualTo(car);
            assertThat(cars.get(1)).isEqualTo(otherCar);
        }
    }
}
