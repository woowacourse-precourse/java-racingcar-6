package racingcar.config;

import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.MockedStatic;
import racingcar.util.Random;

public class RandomMock {
    protected static final int MOVING_FORWARD = 4;
    protected static final int STOP = 3;

    protected static MockedStatic<Random> random;

    @BeforeAll
    static void beforeAll() {
        random = mockStatic(Random.class);
    }

    @AfterAll
    static void afterAll() {
        random.close();
    }
}
