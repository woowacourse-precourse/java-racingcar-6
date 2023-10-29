package racingcar.domain.system.manager;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;
import racingcar.domain.system.manager.car.CarManager;
import racingcar.domain.system.manager.car.InMemoryCarManager;
import racingcar.domain.system.manager.car.SavedCar;
import racingcar.exceptions.runtime.DuplicatedCarNameException;
import racingcar.exceptions.runtime.NotFoundSourceException;

class CarManagerTest {

    @Test
    @DisplayName("자동차를 저장한다.")
    void save() {
        // given
        CarManager manager = new InMemoryCarManager();
        Car car = new Car(new CarName("a"));

        // when
        SavedCar savedCar = manager.save(car);

        // then
        assertEquals(car, savedCar.getCar());
    }

    @Test
    @DisplayName("여러 자동차를 저장한다.")
    void saveAll() {
        // given
        CarManager manager = new InMemoryCarManager();
        Car car1 = new Car(new CarName("a"));
        Car car2 = new Car(new CarName("b"));
        Car car3 = new Car(new CarName("c"));

        // when
        manager.saveAll(List.of(car1, car2, car3));

        // then
        List<Car> savedCars = manager.findAll().stream().map(SavedCar::getCar)
            .collect(Collectors.toList());
        assertThat(savedCars).contains(car1, car2, car3);
    }

    @Test
    @DisplayName("중복된 이름의 자동차를 저장할 수 없다.")
    void saveDuplicatedName() {
        // given
        CarManager manager = new InMemoryCarManager();
        Car car1 = new Car(new CarName("a"));
        Car car2 = new Car(new CarName("a"));
        manager.save(car1);

        // when

        // then
        assertThrows(DuplicatedCarNameException.class, () -> manager.save(car2));
    }

    @Test
    @DisplayName("name으로 자동차를 조회한다.")
    void findByName() {
        // given
        CarManager manager = new InMemoryCarManager();
        Car car1 = new Car(new CarName("a"));
        Car car2 = new Car(new CarName("b"));
        Car car3 = new Car(new CarName("c"));

        manager.saveAll(List.of(car1, car2, car3));

        // when
        SavedCar foundCar = manager.findByName(new CarName("a"));

        // then
        assertEquals(car1, foundCar.getCar());
    }

    @Test
    @DisplayName("존재하지 않는 name으로 자동차를 조회할 수 없다.")
    void findByNameNotFound() {
        // given
        CarManager manager = new InMemoryCarManager();
        Car car1 = new Car(new CarName("a"));
        Car car2 = new Car(new CarName("b"));
        Car car3 = new Car(new CarName("c"));
        manager.saveAll(List.of(car1, car2, car3));

        // when

        // then
        assertThrows(NotFoundSourceException.class, () -> manager.findByName(new CarName("d")));
    }

    @Test
    @DisplayName("모든 자동차를 조회한다.")
    void findAll() {
        // given
        CarManager manager = new InMemoryCarManager();
        Car car1 = new Car(new CarName("a"));
        Car car2 = new Car(new CarName("b"));
        Car car3 = new Car(new CarName("c"));
        manager.saveAll(List.of(car1, car2, car3));

        // when
        List<SavedCar> savedCars = manager.findAll();

        // then
        assertThat(savedCars.stream().map(SavedCar::getCar)).contains(car1, car2, car3);
    }
}