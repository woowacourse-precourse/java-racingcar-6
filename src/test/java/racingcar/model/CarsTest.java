package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.mock.TestNumberGenerator;
import racingcar.model.car.CarDTO;

class CarsTest {
    @Test
    void 생성_중복된_이름_예외_테스트() {
        // given
        List<String> duplicateNames = Arrays.asList("Car1", "Car2", "Car1");

        // then
        assertThatThrownBy(() -> new Cars(duplicateNames, new TestNumberGenerator(5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_DUPLICATE_ERROR.getMessage());
    }

    @Test
    void 이동_테스트() {
        // given
        List<String> names = Arrays.asList("Car1", "Car2", "Car3");
        Cars cars = new Cars(names, new TestNumberGenerator(5));

        // when
        cars.move();
        List<CarDTO> carDTOList = cars.getStatus();

        // then
        carDTOList.forEach(carDTO -> {
            assertThat(carDTO.step()).isEqualTo(1);
        });
    }

    @Test
    void 상태_테스트() {
        // given
        List<String> names = Arrays.asList("Car1", "Car2", "Car3");
        Cars cars = new Cars(names, new TestNumberGenerator(5));

        // when
        List<CarDTO> carDTOList = cars.getStatus();

        // then
        for (CarDTO carDTO : carDTOList) {
            assertThat(carDTO.step()).isEqualTo(0);
        }
    }

    @Test
    void 최대_전진_횟수를_가진_차_찾기_테스트() {
        // given
        List<String> names = Arrays.asList("Car1", "Car2", "Car3");
        Cars cars = new Cars(names, new TestNumberGenerator(5));

        // when
        List<CarDTO> maxStepCars = cars.judge();

        // then
        assertThat(maxStepCars.size()).isEqualTo(3);
        assertThat(maxStepCars.get(0).name()).isEqualTo("Car1");
        assertThat(maxStepCars.get(1).name()).isEqualTo("Car2");
        assertThat(maxStepCars.get(2).name()).isEqualTo("Car3");

    }

}