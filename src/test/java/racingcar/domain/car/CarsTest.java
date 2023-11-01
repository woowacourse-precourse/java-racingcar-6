package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
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

    @Override
    protected void runMain() {

    }
}
