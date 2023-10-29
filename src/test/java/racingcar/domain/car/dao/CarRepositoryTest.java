package racingcar.domain.car.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.domain.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;


class CarRepositoryTest {

    // 1. save
    // 2. findAll
    // 3. findCarWithMaxPosition

    @Nested
    @DisplayName("Car 저장 테스트")
    class SaveCarRepositoryTest {

        @Test
        @DisplayName("Car 객체가 성공적으로 저장되어야 한다.")
        public void Car_객체가_성공적으로_저장되어야_한다() {
            CarRepository carRepository = new CarRepository();
            Car frirstCar = new Car("FirstCarName");
            Car secondCar = new Car("SecondCarName");

            carRepository.save(frirstCar);
            carRepository.save(secondCar);

            List<Car> cars = carRepository.findAll();

            assertThat(cars.get(0).getName()).isEqualTo("FirstCarName");
            assertThat(cars.get(1).getName()).isEqualTo("SecondCarName");

            assertThat(cars.get(0).getPosition()).isEqualTo(0);
            assertThat(cars.get(1).getPosition()).isEqualTo(0);
        }

    }

    @Nested
    @DisplayName("Car 읽기 테스트")
    class findCarRepositoryTest {

        @Test
        @DisplayName("가장 많이 움직인 Car 객체를 읽어와야 한다")
        public void 가장_많이_움직인_Car_객체를_읽어와야_한다() {
            CarRepository carRepository = new CarRepository();
            Car firstCar = Mockito.mock(Car.class);
            Car secondCar = Mockito.mock(Car.class);

            when(firstCar.getName()).thenReturn("firstCar");
            when(secondCar.getName()).thenReturn("secondCar");

            when(firstCar.getPosition()).thenReturn(3);
            when(secondCar.getPosition()).thenReturn(4);

            carRepository.save(firstCar);
            carRepository.save(secondCar);

            List<Car> carWithMaxPosition = carRepository.findCarWithMaxPosition();

            assertThat(carWithMaxPosition.size()).isEqualTo(1);
            assertThat(carWithMaxPosition.get(0).getName()).isEqualTo("secondCar");
            assertThat(carWithMaxPosition.get(0).getPosition()).isEqualTo(4);
        }

        @Test
        @DisplayName("가장 많이 움직인 Car 객체가 여럿일 경우 함께 읽어와야 한다")
        public void 가장_많이_움직인_Car_객체가_여럿일_경우_함께_읽어와야_한다() {
            CarRepository carRepository = new CarRepository();
            Car firstCar = Mockito.mock(Car.class);
            Car secondCar = Mockito.mock(Car.class);
            Car thirdCar = Mockito.mock(Car.class);

            when(firstCar.getName()).thenReturn("firstCar");
            when(secondCar.getName()).thenReturn("secondCar");
            when(thirdCar.getName()).thenReturn("thirdCar");

            when(firstCar.getPosition()).thenReturn(3);
            when(secondCar.getPosition()).thenReturn(4);
            when(thirdCar.getPosition()).thenReturn(4);

            carRepository.save(firstCar);
            carRepository.save(secondCar);
            carRepository.save(thirdCar);

            List<Car> carWithMaxPosition = carRepository.findCarWithMaxPosition();

            assertThat(carWithMaxPosition.size()).isEqualTo(2);
            assertThat(carWithMaxPosition.get(0).getName()).isEqualTo("secondCar");
            assertThat(carWithMaxPosition.get(1).getName()).isEqualTo("thirdCar");
            assertThat(carWithMaxPosition.get(0).getPosition()).isEqualTo(4);
            assertThat(carWithMaxPosition.get(1).getPosition()).isEqualTo(4);
        }

    }


}
