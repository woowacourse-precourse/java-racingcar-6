package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 단독_우승자_출력_확인(){
        assertRandomNumberInRangeTest(
                ()  -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains("pobi : -", "woni : --", "jun : -",
                            "pobi : ---", "woni : -", "jun : ", "최종 우승자 : pobi");
                },
                4,5,4,6,4,3
        );
    }

    @Test
    void 공동_우승자_출력_확인(){
        assertRandomNumberInRangeTest(
                ()  -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains("pobi : -", "woni : --", "jun : -",
                            "pobi : --", "woni : -", "jun : ", "최종 우승자 : pobi, woni");
                },
                4,5,4,5,4,3
        );
    }

    @Test
    void 경주_참여_자동차_0대(){ //자동차의 이름을 입력하지 않은 경우 이름의 길이가 0이 되어 이름 길이 조건을 위반하게 된다.
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력 가능한 자동차 이름 길이를 위반하였습니다.")
        );
    }

    @Test
    void 이름_길이_위반_예외_처리_길이0(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jun,,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력 가능한 자동차 이름 길이를 위반하였습니다.")
        );
    }

    @Test
    void 이름_길이_위반_예외_처리_길이5_초과(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jun,pobibi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력 가능한 자동차 이름 길이를 위반하였습니다.")
        );
    }

    @Test
    void 중복된_이름_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("중복된 자동차 이름이 있습니다.")
        );
    }

    @Test
    void 영문_아닌_이름_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("포비,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름에는 영문만 사용 가능합니다.")
        );
    }

    @Test
    void 영문_아닌_이름_예외_처리2(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jun12,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름에는 영문만 사용 가능합니다.")
        );
    }

    @Test
    void 이름_공백_예외_처리(){ //공백 문자도 영문이 아닌 문자에 포함되어 영문 처리 정규표현식에 걸러진다.
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("p bi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름에는 영문만 사용 가능합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
