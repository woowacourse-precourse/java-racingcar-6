package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest( // values 3으로 이뤄진 배열이 됨. 따라서 첫번째 pobi는 4, woni는 3의 값을 가짐.
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
    void 이름을_알맞게_나누는지() {
        CallNsTestMethod testMethod = new CallNsTestMethod();
        String inputName = "aaa,bbb,ccc,ddd, cc.dd";
        testMethod.myCommand(inputName);
        RacingGame racingGame = new RacingGame();
        List<String> nameList = racingGame.inputCarName();
        assertThat(nameList.get(0)).isEqualTo("aaa");
        assertThat(nameList.get(1)).isEqualTo("bbb");
        assertThat(nameList.get(2)).isEqualTo("ccc");
        assertThat(nameList.get(3)).isEqualTo("ddd");
        assertThat(nameList.get(4)).isEqualTo("cc.dd");
    }

    @Test
    void 숫자값_잘못_입력시_예외_처리() {
        String inputName = "-5";
        CallNsTestMethod.myCommand(inputName);
        RacingGame racingGame = new RacingGame();
        assertThatThrownBy(() -> racingGame.inputCountNum()).isInstanceOf(IllegalArgumentException.class);
    }
    

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
