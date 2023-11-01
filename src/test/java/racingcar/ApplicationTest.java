package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.service.CheckTryNumber;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 시도숫자_0일때_예외처리() {
        assertTrue(CheckTryNumber.checkIsZero(5));
        assertFalse(CheckTryNumber.checkIsZero(0));
    }

    @Test
    public void Car_세팅_테스트() {
        Car car = new Car("testCar");
        assertEquals("", car.getStat());
    }

    @Test
    public void UpdateStat_메서드_확인_테스트() {
        Car car = new Car("testCar");
        car.updateStat();
        assertEquals("-", car.getStat());
    }

    @Test
    public void UpdateCarList_테스트() {
        Racing racing = new Racing();
        racing.updateCarList(Arrays.asList("car1", "car2", "car3"));
        assertEquals(3, racing.carList.size());
    }

    @Test
    public void playGame_테스트() {
        Racing racing = new Racing();

        String inputString = "testCar1,testCar2,testCar3";
        int numberOfTry = 5;
        List<String> carArray = Arrays.asList(inputString.split(","));


        racing.updateCarList(carArray);
        for (int i = 0; i < numberOfTry; i++) {
            racing.executingGame(racing.carList);
            OutputView.printExecutionMessage(racing.carList);
        }

        assertNotNull(racing.getWinner());
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
