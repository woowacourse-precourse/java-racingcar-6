package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomGenerator;
import racingcar.util.RandomNumberGeneratorTest;
import racingcar.view.input.error.InputIllegalArgumentException;

public class CarsTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void Cars_Constructor이_정상_작동하는지_Test() {
        List<String> carNames = List.of("뛰뛰", "빵빵", "뛰뛰빵빵");
        Cars cars = new Cars(carNames);

        assertNotNull(cars);
    }

    @Test
    void validateCanRace가_정상_작동하는지_Test() {
        List<String> carNames = List.of("나혼자뛰뛰..");

        assertThrows(InputIllegalArgumentException.class, () -> new Cars(carNames));
    }

    @Test
    void 차가_움직이는지_Test() {
        Cars cars = new Cars(Arrays.asList("pobi", "wooni"));
        RandomGenerator randomGenerator = new RandomNumberGeneratorTest(MOVING_FORWARD);

        cars.randomMove(randomGenerator);
        Map<String, String> carStatus = cars.generateStatus();

        assertEquals("{pobi=-, wooni=-}", carStatus.toString());
    }

    @Test
    void 차가_움직이지않는지_Test() {
        Cars cars = new Cars(Arrays.asList("pobi", "wooni"));
        RandomGenerator randomGenerator = new RandomNumberGeneratorTest(STOP);

        cars.randomMove(randomGenerator);
        Map<String, String> carStatus = cars.generateStatus();

        assertEquals("{pobi=, wooni=}", carStatus.toString());
    }

    @Override
    protected void runMain() {

    }
}
