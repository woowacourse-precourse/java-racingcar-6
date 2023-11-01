package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsRepositoryTest {

    CarsRepository repository = CarsRepository.getInstance();

    @DisplayName("시합에 참여하는 자동차를 등록할 수 있다.")
    @Test
    void save2() {
        // given
        List<String> carNames = List.of("aaa", "bbb", "ccc");
        Cars cars = Cars.from(carNames);

        // when
        repository.save(cars);
        Cars findCars = repository.findCars().get();

        // then
        assertThat(findCars).isEqualTo(cars);
    }
}