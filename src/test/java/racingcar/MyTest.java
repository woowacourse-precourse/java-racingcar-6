package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest extends NsTest {
    @Test
    @DisplayName("라운드가 0이하의 입력일때의 예외처리 테스트")
    public void 라운드_음수입력_예외확인_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Judy,Popo", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        ;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Judy,Popo", "-10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("라운드 문자 입력 예외 처리 테스트")
    public void 라운드_문자입력_예외확인_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Judy,Popo", "4applemango"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Judy,Popo", "3test!!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("쉼표 구분자 안에 이름이 없는 경우 에러 처리")
    public void 쉼표_구분자_이름_에러확인_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,PoCO", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("쉼표 구분자 안에 공백만 있는 경우 에러 처리")
    public void 쉼표_구분자_공백만_있는_경우_에러_체크() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,        ,PoCO,hoon", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("정상 로직 수행")
    public void 정상_로직_수행(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("tobi, judy, candy", "4");
                    assertThat(output()).contains("tobi : ----", "judy : -", "candy : --", "최종 우승자 : tobi");
                },
                9,8,7,5,0,3,6,2,4,9,1,1
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
