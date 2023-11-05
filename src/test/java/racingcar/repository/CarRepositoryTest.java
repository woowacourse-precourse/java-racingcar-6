package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarRepositoryTest extends NsTest {

    @Test
    void 레포지토리에_자동차_저장_후_id로_확인() {
        CarRepository carRepository = new CarRepository();
        carRepository.save(new Car("a"));
        carRepository.save(new Car("b"));
        carRepository.save(new Car("c"));
        assertThat(carRepository.findById(0L).getName()).isEqualTo("a");
        assertThat(carRepository.findById(1L).getName()).isEqualTo("b");
        assertThat(carRepository.findById(2L).getName()).isEqualTo("c");
    }

    @Test
    void 레포지토리에_자동차_저장_후_전체_확인() {
        CarRepository carRepository = new CarRepository();
        carRepository.save(new Car("a"));
        carRepository.save(new Car("b"));
        carRepository.save(new Car("c"));
        assertThat(carRepository.findAll()).hasSize(3);
    }

    @Override
    protected void runMain() {
    }
}
