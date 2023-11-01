package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 유효한_자동차_이름_파싱() {
        List<String> carNames = Application.getCarNames("pobi,woni,jun");
        // 예상하는 자동차 이름 리스트와 비교
        List<String> expectedCarNames = Arrays.asList("pobi", "woni", "jun");
        assertEquals(expectedCarNames, carNames);
    }

    @Test
    void 유효한_자동차_이름_검증() {
        String validInput = "pobi,woni,jun";
        assertThatCode(() -> Application.validateInputCarName(validInput))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름_빈값_입력() {
        String emptyInput = "";
        assertThatThrownBy(() -> Application.validateInputCarName(emptyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_띄어쓰기() {
        String spaceInput = "pobi, woni, jun";
        assertThatThrownBy(() -> Application.validateInputCarName(spaceInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_5자_초과() {
        String longNamesInput = "pobi,woni,juneeeeeeeeee";
        assertThatThrownBy(() -> Application.validateInputCarName(longNamesInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_무브() {
        Car car = new Car("testCar");

        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertEquals(1, car.getPosition());

                    car.move();
                    assertEquals(2, car.getPosition()); // Random number 2 is less than 4, so position remains the same.

                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
