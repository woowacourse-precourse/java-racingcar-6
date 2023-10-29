package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarRepositoryTest {

    @Test
    @DisplayName("자동차 저장 후 저장된 개수를 비교해서 잘 저장 됐는지 테스트한다.")
    void saveTest() {
        // given
        CarRepository carRepository = new CarRepository();
        List<String> carNames = List.of("pobi", "woni", "jun");

        // when
        carNames.stream()
                .map(Car::new)
                .forEach(carRepository::save);

        // then
        assertThat(carRepository.getCars().size()).isEqualTo(3);
    }
}