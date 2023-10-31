package racingcar.unitTest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.repository.InMemoryRepository;
import racingcar.model.vo.Attempt;
import racingcar.model.vo.CarName;

public class InMemoryRepositoryTest {
    private InMemoryRepository inMemoryRepository;

    @BeforeEach
    void setUp() {
        inMemoryRepository = new InMemoryRepository();
    }

    @Test
    void should_true_when_saveCarSuccessful() {
        // given
        CarName carName = new CarName("park");
        Car car = new Car(carName);
        // when
        inMemoryRepository.save(carName, car);
        // then
        assertThat(inMemoryRepository.findByCarName(carName))
                .isEqualTo(car);
    }

    @Test
    void should_true_when_saveAttemptSuccessful() {
        // given
        Attempt attempt = new Attempt(5);
        // when
        inMemoryRepository.save(attempt);
        // then
        assertThat(inMemoryRepository.findAttempt())
                .isEqualTo(attempt);
    }
}
