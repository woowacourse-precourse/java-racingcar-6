package racingcar.domain.car.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import racingcar.domain.car.Car;
import racingcar.domain.util.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static racingcar.domain.util.ErrorMessage.*;


class CarRepositoryTest {

    private CarRepository carRepository;
    private Car firstCar;
    private Car secondCar;
    private Car thirdCar;

    @BeforeEach
    public void setUp() {
        carRepository = new CarRepository();
        firstCar = mock(Car.class);
        secondCar = mock(Car.class);
        thirdCar = mock(Car.class);
    }

    @AfterEach
    public void clear() {
        carRepository.clear();
    }

    @Nested
    @DisplayName("Car 저장 테스트")

    class SaveCarRepositoryTest {

        @Test
        @DisplayName("Car 객체가 성공적으로 저장되어야 한다.")
        public void Car_객체가_성공적으로_저장되어야_한다() {
            carRepository.clear();
            carRepository.save(new Car("FirstCarName"));
            carRepository.save(new Car("SecondCarName"));

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
            when(firstCar.getName()).thenReturn("firstCar");
            when(secondCar.getName()).thenReturn("secondCar");

            when(firstCar.getPosition()).thenReturn(3);
            when(secondCar.getPosition()).thenReturn(4);

            carRepository.clear();
            carRepository.save(firstCar);
            carRepository.save(secondCar);

            List<Car> carWithMaxPosition = carRepository.findAllCarsWithMaxPosition();

            assertThat(carWithMaxPosition.size()).isEqualTo(1);
            assertThat(carWithMaxPosition.get(0).getName()).isEqualTo("secondCar");
            assertThat(carWithMaxPosition.get(0).getPosition()).isEqualTo(4);
        }

        @Test
        @DisplayName("가장 많이 움직인 Car 객체가 여럿일 경우 함께 읽어와야 한다")
        public void 가장_많이_움직인_Car_객체가_여럿일_경우_함께_읽어와야_한다() {
            when(firstCar.getName()).thenReturn("firstCar");
            when(secondCar.getName()).thenReturn("secondCar");
            when(thirdCar.getName()).thenReturn("thirdCar");

            when(firstCar.getPosition()).thenReturn(3);
            when(secondCar.getPosition()).thenReturn(4);
            when(thirdCar.getPosition()).thenReturn(4);

            carRepository.clear();
            carRepository.save(firstCar);
            carRepository.save(secondCar);
            carRepository.save(thirdCar);

            List<Car> carWithMaxPosition = carRepository.findAllCarsWithMaxPosition();

            assertThat(carWithMaxPosition.size()).isEqualTo(2);
            assertThat(carWithMaxPosition.get(0).getName()).isEqualTo("secondCar");
            assertThat(carWithMaxPosition.get(1).getName()).isEqualTo("thirdCar");
            assertThat(carWithMaxPosition.get(0).getPosition()).isEqualTo(4);
            assertThat(carWithMaxPosition.get(1).getPosition()).isEqualTo(4);
        }

    }

    @Nested
    @DisplayName("데이터베이스 초기화 테스트")
    class clearDatabaseTest {

        @Test
        @DisplayName("데이터베이스를 성공적으로 초기화 해야 한다")
        public void 데이터베이스를_성공적으로_초기화_해야_한다() {
            carRepository.clear();
            carRepository.save(firstCar);
            carRepository.save(secondCar);
            carRepository.save(thirdCar);

            assertThat(carRepository.findAll()).hasSize(3);

            carRepository.clear();
        }
    }

    @Nested
    @DisplayName("예외 테스트")
    class ExceptionTest {

        @Test
        @DisplayName("DB에 Car 객체가 없는 경우 예외를 발생시켜야 한다")
        public void DB에_Car_객체가_없는_경우_예외를_발생시켜야_한다() {
            carRepository.clear();

            // junit.jupiter
            assertThrows(IllegalArgumentException.class,
                    carRepository::findAllCarsWithMaxPosition,
                    CAR_NOT_EXIST.getErrorMessage());

            assertThrows(IllegalArgumentException.class,
                    carRepository::findAll,
                    CAR_NOT_EXIST.getErrorMessage());

            // org.assertj.core
            assertThatThrownBy(carRepository::findAll)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NOT_EXIST.getErrorMessage());

            assertThatThrownBy(carRepository::findAllCarsWithMaxPosition)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NOT_EXIST.getErrorMessage());
        }
    }
}
