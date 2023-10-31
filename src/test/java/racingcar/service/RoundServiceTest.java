package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.RandomNumberImpl;

public class RoundServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 랜덤값이_4이상일떄_이동조건_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RoundService roundService = new RoundService((start, end) -> MOVING_FORWARD);

        Method method = RoundService.class.getDeclaredMethod("randomMoveSelect");
        method.setAccessible(true);

        boolean check = (boolean) method.invoke(roundService);
        assertThat(check).isEqualTo(true);
    }

    @Test
    void 랜덤값이_3이하일떄_멈춤조건_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RoundService roundService = new RoundService((start, end) -> STOP);

        Method method = RoundService.class.getDeclaredMethod("randomMoveSelect");
        method.setAccessible(true);

        boolean check = (boolean) method.invoke(roundService);
        assertThat(check).isEqualTo(false);
    }


    @Test
    void 랜덤값이_4이상일떄_이동조건_테스트_우아한테스트_사용() throws NoSuchMethodException {
        RoundService roundService = new RoundService(new RandomNumberImpl());

        Method method = RoundService.class.getDeclaredMethod("randomMoveSelect");
        method.setAccessible(true);

        assertRandomNumberInRangeTest(
                () -> {
                    boolean check = (boolean) method.invoke(roundService);
                    assertThat(check).isEqualTo(true);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 랜덤값이_3이하일떄_멈춤조건_테스트_우아한테스트_사용() throws NoSuchMethodException {
        RoundService roundService = new RoundService(new RandomNumberImpl());

        Method method = RoundService.class.getDeclaredMethod("randomMoveSelect");
        method.setAccessible(true);

        assertRandomNumberInRangeTest(
                () -> {
                    boolean check = (boolean) method.invoke(roundService);
                    assertThat(check).isEqualTo(false);
                },
                STOP
        );
    }

    @Test
    void 자동차_전체_전진멈춤() {
        RoundService roundService = new RoundService(new RandomNumberImpl());

        List<Car> actual = Arrays.asList(new Car("pobi"), new Car("jiho"), new Car("java"));
        List<Integer> expected = Arrays.asList(1, 0, 1);

        assertRandomNumberInRangeTest(
                () -> {
                    roundService.moveCarsByRandom(actual);
                    List<Integer> moveAfter = actual.stream().map(Car::getPosition).collect(Collectors.toList());
                    assertThat(moveAfter).isEqualTo(expected);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}
