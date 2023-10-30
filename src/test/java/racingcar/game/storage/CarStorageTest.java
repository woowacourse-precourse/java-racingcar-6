package racingcar.game.storage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.game.car.Car;

class CarStorageTest {
    CarStorage carStorage;

    @BeforeEach
    void setUp() {
        carStorage = new CarStorage();
    }

    @Test
    @DisplayName("자동차 저장에 성공한다.")
    void test_SaveCarSuccessful() {
        //given
        Car car = new Car("car");

        //when
        Car savedCar = carStorage.saveCar(car);

        //then
        assertThat(savedCar).isSameAs(car);
    }

    @Test
    @DisplayName("저장된 자동차들을 성공적으로 읽는다.")
    void test_GetStoredCarsSuccessful() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        carStorage.saveCar(car1);
        carStorage.saveCar(car2);

        //when
        List<Car> cars = carStorage.getStoredCars();

        //then
        assertThat(cars).hasSize(2);
    }

    @Test
    @DisplayName("전진 거리가 가장 긴 자동차를 구할 때 저장된 자동차가 없으면 빈 Optional을 반환한다..")
    void test_GetLeadingCarFailed_NoCarStored() {
        //when
        Optional<Car> car = carStorage.getLeadingCar();

        //then
        assertThat(car).isEmpty();
    }

    @Test
    @DisplayName("저장된 자동차들 중 가장 전진 거리가 긴 자동차를 성공적으로 반환한다.")
    void test_GetLeadingCarSuccessful_OnlyOneFound() {
        //given
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 1);
        carStorage.saveCar(car1);
        carStorage.saveCar(car2);

        //when
        Optional<Car> leadingCar = carStorage.getLeadingCar();

        //then
        assertThat(leadingCar).isNotEmpty();
        assertThat(leadingCar.get()).isSameAs(car1);
    }

    @Test
    @DisplayName("여러 자동차 중 가장 전진 거리가 긴 자동차가 두 대 이상이면 둘 중 하나를 반환해야한다.")
    void test_GetLeadingCarSuccessful_MultipleFound() {
        //given
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 3);
        carStorage.saveCar(car1);
        carStorage.saveCar(car2);
        carStorage.saveCar(car3);

        //when
        Optional<Car> leadingCar = carStorage.getLeadingCar();

        //then
        assertThat(leadingCar).isNotEmpty();
        assertThat(leadingCar.get()).isIn(List.of(car1, car3));
    }

    @Test
    @DisplayName("공동 우승자가 없을 때 자동차를 하나만 가지고 있는 리스트를 반환해야한다.")
    void test_GetWinnersSuccessful_ReturnOneWinner() {
        //given
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 1);
        carStorage.saveCar(car1);
        carStorage.saveCar(car2);

        //when
        List<Car> winners = carStorage.getWinners(car1);

        //then
        assertThat(winners).hasSize(1);
    }

    @Test
    @DisplayName("공동 우승자가 있을 때 우승자들의 리스트를 반환해야한다.")
    void test_GetWinnersSuccessful_ReturnMultipleWinners() {
        //given
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 3);
        carStorage.saveCar(car1);
        carStorage.saveCar(car2);
        carStorage.saveCar(car3);

        //when
        List<Car> winners = carStorage.getWinners(car1);

        //then
        assertThat(winners).hasSize(2).contains(car1, car3);
    }
}
