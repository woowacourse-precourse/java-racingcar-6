package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // carList Class
    @Test
    void CarNameMethodSuccess(){
        CarList carList = new CarList();
        carList.setCarName("pobi,woni");
        assertTrue(carList.checkCarName());
    }

    @Test
    void hasAtLeastTwoItemsFailed(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void isDuplicateFailed(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void isShortNameFailed(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,,amy", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void isEnglishNameFailed(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㄱ,name", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // RacingNumber Class
    @Test
    void RacingNumberSuccess(){
        RacingNumber racingNumber = new RacingNumber();
        racingNumber.setRacingNum("1");
        assertTrue(racingNumber.isPositiveInteger());
    }

    @Test
    void isPositiveIntegerFailed(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("name", "10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}