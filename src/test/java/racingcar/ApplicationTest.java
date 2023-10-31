package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "Garen";
        ArrayList<String> list = Application.carNameSplit(input);
        assertThat(list).contains("Garen");
    }

    @Test
    void 자동차_이름의_길이가_5보다_긴_경우에_대한_예외_처리(){
        String input = "Garen,Galio,Gangplank,Gragas";
        assertThatThrownBy(() -> Application.carNameSplit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름의 길이가 5보다 깁니다.");
    }

    @Test
    void 시도할_횟수_입력이_잘못된_경우에_대한_예외_처리(){
        String input = "abc";
        assertThatThrownBy(() -> new Control(input, new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수의 입력이 잘못 되었습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
