package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest extends NsTest {
    Car car = new Car("a", 2);
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 무작위_값_생성_0에서_9사이() {
        int randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
        Assertions.assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }

    @Test
    void 전진_혹은_멈춤() {
        //무작위 값이 4 이상인 경우
        car.randomNumber = 5;
        car.turn = 0;
        car.goOrStop();
        assertEquals("-", car.result[0]);
        assertEquals(car.turn, 1);

        // 무작위 값이 4 미만인 경우
        car.randomNumber = 3;
        car.turn = 0;
        car.goOrStop();
        assertEquals(" ", car.result[0]);
        assertEquals(car.turn, 1);
    }

    @Test
    void 전진() {
        car.totalGoNumber = 0;
        car.go();
        String result = car.result[car.turn];
        assertEquals(result, "-");
        assertEquals(car.totalGoNumber, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}