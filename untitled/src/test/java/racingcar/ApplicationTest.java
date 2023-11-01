package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class ApplicationTest extends NsTest{
    @Test
    void 게임종료_후_재시작(){
        assertRandomNumberInRangeTest(
                ()->{
                    run("car1,car2,car3","1");
                    assertThat(output()).contains("car3");
                },
                0,0,0,0,0,5
        );
    }
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1","-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application app = new Application();
        app.main(new String[]{});
    }
}