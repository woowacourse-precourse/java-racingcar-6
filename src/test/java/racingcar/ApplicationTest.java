package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 이름에_대한_중복_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 이름에_대한_특수문자_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi!", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_쉼표_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,kyu", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 우승자가_다수일_경우에_대한_예외_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,kyu", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "kyu : -", "최종 우승자 : pobi, woni, kyu");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 움직이지_않아도_우승_가능() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : ", "최종 우승자 : pobi");
                },
                STOP
        );
    }

    @Test
    void getCarNamesArray_메서드의_동작_확인() {
        // given
        CarRacing carRacing = new CarRacing();
        String carNames = "pobi,kyu,joa";
        List<String> carNamesArray = new ArrayList<>();

        // when
        carNamesArray = carRacing.getCarNamesArray(carNames);

        // then
        assertThat(carNamesArray).containsExactly("pobi", "kyu", "joa");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
