package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("이름에 대한 예외 처리-5자리 보다 긴 이름")
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름에 대한 예외 처리-1자리 보다 작은 이름")
    void 이름에_대한_예외_처리_작은길이(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,java"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름에 대한 예외 처리-공백")
    void 이름에_대한_예외_처리_공백(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수에 대한 예외 처리-공백")
    void 시도_횟수에_대한_예외_처리_공백(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수에 대한 예외 처리-문자")
    void 시도_횟수에_대한_예외_처리_문자(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수에 대한 예외 처리-실수")
    void 시도_횟수에_대한_예외_처리_실수(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1.1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수에 대한 예외 처리-음수")
    void 시도_횟수에_대한_예외_처리_음수(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름 입력 도움 문구 출력")
    void 이름입력_문구출력() {
        assertSimpleTest(() -> {
                    run("pobi", "1");
                    assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                }
        );
    }

    @Test
    @DisplayName("시도 횟수 입력 도움 문구 출력")
    void 시도횟수입력_문구출력() {
        assertSimpleTest(() -> {
                    run("pobi", "1");
                    assertThat(output()).contains("시도할 회수는 몇회인가요?");
                }
        );
    }

    @Test
    @DisplayName("최소한 10번 이상 같은 이릉밍 출력되는지 확인")
    void 실행_결과_출력() {
        assertSimpleTest(() -> {
                    run("pobi,andy,hola", "10");
                    assertThat(output().split("pobi", -1).length - 1<10).isFalse();
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
