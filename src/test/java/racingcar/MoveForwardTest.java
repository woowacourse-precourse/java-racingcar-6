package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;
import racingcar.factories.CarFactory;
import racingcar.underhood.Car;
import racingcar.underhood.GameRule;

public class MoveForwardTest {

    static GameRule rule = new GameRule(0, 9);
    static String[] names;
    Car car;

    @BeforeEach
    void setCarRecordWithDefaultNames() {
        car = CarFactory.car(rule, "M240i");
    }

    @Test
    void 이동거리_0() {
        assertInDifferentThread(() -> {
            assertWithMockedRandomNumberGenerator(3, () -> {
                car.moveForward();
                assertThat(car.getDistance()).isEqualTo(0);
            });
        });
    }

    @Test
    void 이동거리_1() {
        assertInDifferentThread(() -> {
            assertWithMockedRandomNumberGenerator(6, () -> {
                car.moveForward();
                assertThat(car.getDistance()).isEqualTo(1);
            });
        });
    }

    /**
     * 전달받은 FunctionalInterface를 별도의 스레드에서 실행한다.
     */
    static void assertInDifferentThread(final Executable executable) {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1L), executable::execute);
    }

    /**
     * 전달받은 FunctionalInterface는 RandomNumberGenerator가 randomNumber를 반환하는 환경에서 실행된다.
     */
    static void assertWithMockedRandomNumberGenerator(
            int randomNumber, final Executable executable) {
        try (final MockedStatic<RandomNumberGenerator> mocked = mockStatic(RandomNumberGenerator.class);) {
            // given
            mocked.when(() -> RandomNumberGenerator.pickRandomNumber(any()))
                    .thenReturn(randomNumber);
            // when && then
            executable.execute();
        } catch (Throwable e) {
            Assertions.fail(e.getMessage());
        }
    }
}
