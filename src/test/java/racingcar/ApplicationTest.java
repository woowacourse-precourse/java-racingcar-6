package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Play;
import racingcar.domain.UserInput;
import racingcar.exception.NameException;

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
    @DisplayName("이름이 5자가 넘어갈 경우")
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

    @Test
    @DisplayName("자동차가 한 대만 입력 됐을 경우")
    void 이름에_대한_예외_처리2(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("red"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("공백이 입력된 경우")
    void 이름에_대한_예외_처리3(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("red, blue"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름이 중복된 경우")
    void 이름에_대한_예외_처리4(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("red,red"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_자동차_이름_예외_처리() {
        assertThatThrownBy(() -> {
            String emptyCarName = "";
            NameException.checkEmpty(List.of(emptyCarName));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("횟수에 문자가 입력됐을 경우")
    void 횟수에_대한_예외_처리1(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("red,blue", "one"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("횟수가 0일 경우")
    void 횟수에_대한_예외_처리2(){
            assertThatThrownBy(() -> runException("red,blue", "0"))
                        .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 다수의_우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }
}
