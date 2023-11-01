package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String CARNAME = "bora,dori,nana";
    private static final String CARNAME_WITH_BLANK = "bora,,nana,ddubi";

    @Test
    @DisplayName("from 함수 기능 테스트")
    void 입력_사이에_빈_값이_들어왔을_경우_제거_후_반환_기능_테스트() {
        //given
        Cars cars = Cars.from(CARNAME_WITH_BLANK);
        //then
        assertEquals(cars.getCarList().size(), 3);
    }

    @Test
    @DisplayName("findWinners 함수 기능 테스트")
    void 우승자_반환_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Cars cars = Cars.from(CARNAME);
            cars.moveCars();
            List<String> winners = cars.findWinners();
            assertEquals(winners.size(), 2);
            assertEquals(winners.get(0), "bora");
            assertEquals(winners.get(1), "nana");
        }, MOVING_FORWARD, STOP, MOVING_FORWARD);
    }


    @Test
    @DisplayName("getCarList 함수 기능 테스트")
    void 자동차_목록_반환_기능_테스트() {
        //given
        Cars cars = Cars.from(CARNAME);
        //then
        assertEquals(cars.getCarList().size(), 3);
    }

    @Test
    @DisplayName("moveCars 함수 기능 테스트")
    void 자동차_이동_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Cars cars = Cars.from(CARNAME);
            cars.moveCars();
            assertEquals(cars.getCarList().get(0).getPosition(), 1);
            assertEquals(cars.getCarList().get(1).getPosition(), 1);
            assertEquals(cars.getCarList().get(2).getPosition(), 0);
        }, MOVING_FORWARD, MOVING_FORWARD, STOP);
    }

    @Override
    protected void runMain() {

    }
}