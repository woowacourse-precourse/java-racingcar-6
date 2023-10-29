package racingcar.domain.system.manager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;
import racingcar.domain.system.manager.car.SavedCar;
import racingcar.domain.system.manager.position.CarPositionManager;
import racingcar.domain.system.manager.position.InMemoryCarPositionManager;
import racingcar.domain.system.manager.position.SavedCarPosition;
import racingcar.exceptions.runtime.NotFoundSourceException;

class CarPositionManagerTest {

    @Test
    @DisplayName("자동차 위치를 저장한다.")
    void save() {
        // given
        CarPositionManager manager = new InMemoryCarPositionManager();

        SavedCar car = new SavedCar(new Car(new CarName("a")));
        Long position = 1L;

        // when
        SavedCarPosition savedPosition = manager.save(car, position);

        // then
        assertEquals(position, savedPosition.getPosition());
    }

    @Test
    @DisplayName("여러 자동차 위치를 저장한다.")
    void saveAll() {
        // given
        CarPositionManager manager = new InMemoryCarPositionManager();

        SavedCar car1 = new SavedCar(new Car(new CarName("b")));
        SavedCar car2 = new SavedCar(new Car(new CarName("c")));
        SavedCar car3 = new SavedCar(new Car(new CarName("d")));
        Long car1Position = 1L;
        Long car2Position = 2L;
        Long car3Position = 3L;

        Map<SavedCar, Long> carPositions = new HashMap<>();
        carPositions.put(car1, car1Position);
        carPositions.put(car2, car2Position);
        carPositions.put(car3, car3Position);

        // when
        List<SavedCarPosition> savedPositions = manager.saveAll(carPositions);

        // then
        assertThat(savedPositions.stream().map(SavedCarPosition::getPosition)).contains(
            car1Position, car2Position, car3Position);
    }

    @Test
    @DisplayName("자동차 위치를 조회한다.")
    void findByCar() {
        // given
        CarPositionManager manager = new InMemoryCarPositionManager();

        SavedCar car = new SavedCar(new Car(new CarName("a")));
        Long position = 1L;
        manager.save(car, position);

        // when
        SavedCarPosition savedPosition = manager.findByCar(car);

        // then
        assertEquals(position, savedPosition.getPosition());
    }

    @Test
    @DisplayName("없는 자동차 조회시 예외 발생")
    void findByCarWithNotFoundCar() {
        // given
        CarPositionManager manager = new InMemoryCarPositionManager();
        SavedCar car = new SavedCar(new Car(new CarName("a")));
        Long position = 1L;
        manager.save(car, position);

        // when

        // then
        assertAll(
            () -> assertEquals(position, manager.findByCar(car).getPosition()),
            () -> assertThrows(
                NotFoundSourceException.class,
                () -> manager.findByCar(new SavedCar(new Car(new CarName("b"))))
            ));
    }

    @Test
    @DisplayName("저장된 자동차들의 위치를 조회한다.")
    void findAll_SavedCars() {
        // given
        CarPositionManager manager = new InMemoryCarPositionManager();

        SavedCar car1 = new SavedCar(new Car(new CarName("a")));
        SavedCar car2 = new SavedCar(new Car(new CarName("b")));
        Long car1Position = 1L;
        Long car2Position = 2L;

        manager.save(car1, car1Position);
        manager.save(car2, car2Position);

        // when
        Map<CarName, SavedCarPosition> carPositions = manager.findAll(List.of(car1, car2));

        // then
        assertAll(
            () -> assertThat(carPositions).containsKeys(car1.getKey(),
                car2.getKey()),
            () -> assertThat(carPositions.values().stream().map(SavedCarPosition::getPosition))
                .contains(car1Position, car2Position),
            () -> assertEquals(carPositions.get(car1.getKey()).getPosition(),
                car1Position),
            () -> assertEquals(carPositions.get(car2.getKey()).getPosition(),
                car2Position)
        );
    }
}