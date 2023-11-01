package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

//    @Test
//    void 전진_정지() {
//        assertRandomNumberInRangeTest(
//            () -> {
//                run("pobi,woni", "1");
//                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
//            },
//            MOVING_FORWARD, STOP
//        );
//    }

    @Test
    void 이름_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> InputView.checkName("123456"));
    }


    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "pobi,woni,jun";
        String[] result = input.split(",");

        assertThat(result).contains("woni", "jun", "pobi");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
