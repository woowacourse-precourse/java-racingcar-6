package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.repository.CarRepositoryImpl;
import racingcar.repository.Repository;
import racingcar.service.InputService;
import racingcar.service.InputServiceImpl;

public class ValidateTest {
    Repository repository = new CarRepositoryImpl();

    @Test
    void nameExceptionTest() {
        // when
        String[] names = {"a", "abscds"};

        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> repository.save(names));
    }
}
