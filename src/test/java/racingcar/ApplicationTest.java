package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testGetIndicesOfMaxValues() {
        int[] array = {2, 4, 6, 4, 5};
        int[] result = Application.getIndicesOfMaxValues(array);
        assertArrayEquals(new int[]{2}, result);
    }

    @Test
    public void testNameSplit() {
        String input = "Car1,Car2,Car3";
        String[] result = Application.nameSplit(input);
        assertArrayEquals(new String[]{"Car1", "Car2", "Car3"}, result);
    }

    @Test
    public void testCarToCarsArr() {
        String[] playerArr = {"Car1", "Car2", "Car3"};
        Car[] cars = new Car[playerArr.length];
        Application.carToCarsArr(playerArr, cars);
        assertEquals("Car1", cars[0].getName());
        assertEquals("Car2", cars[1].getName());
        assertEquals("Car3", cars[2].getName());
    }

    @Test
    public void testTotalGameProgress() {
        String[] playerArr = {"Car1", "Car2"};
        int[] total = new int[playerArr.length];
        Car[] cars = new Car[playerArr.length];
        Application.carToCarsArr(playerArr, cars);
        Application.totalGameProgress(playerArr, total, cars);
        assertEquals(cars[0].getGameProgress(), total[0]);
        assertEquals(cars[1].getGameProgress(), total[1]);
    }

    @Test
    public void testIsStrLenOutOfRange() {
        String[] playerArr = {"Car1", "Car2", "Car345"};
        assertThrows(IllegalArgumentException.class, () -> Application.isStrLenOutOfRange(playerArr));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
