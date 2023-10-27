package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceJudgeTest {

    CarRaceJudge carRaceJudge = new CarRaceJudge();
    CarRepository carRepository = CarRepository.getInstance();

    @DisplayName("심판은 레이스할 자동차를 등록합니다.")
    @Test
    void addCars() {
        // given
        List<String> names = List.of("pobi", "jason");
        List<Car> cars = List.of(Car.of("pobi", 0),
                Car.of("jason", 0));

        // when
        carRaceJudge.addCars(names);
        List<Car> findCars = carRepository.findAll();
        boolean isSaved = findCars.containsAll(cars);

        // then
        assertThat(isSaved).isTrue();
    }
}