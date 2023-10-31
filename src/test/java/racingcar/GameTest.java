package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest extends NsTest {
    private static final int GO=4;
    private static final int STOP=3;

    @Test
    @DisplayName("실행 결과값 테스트")
    void 실행_테스트() {
        assertRandomNumberInRangeTest(
                ()->{
                    run("kim,ki,yoon","10");
                    assertThat(output()).contains("kim : -", "ki : --","yoon : -", "최종 우승자 : ki");
                },
                GO,GO,GO,STOP,STOP,STOP,STOP,GO,STOP,STOP
        );
    }

    @Test
    @DisplayName("공동 우승 테스트")
    void 공동_우승() {
        assertRandomNumberInRangeTest(
                ()->{
                    run("kim,ki,yoon","3");
                    assertThat(output())
                            .contains("kim : -", "ki : -","yoon : -", "최종 우승자 : kim, ki, yoon");
                },
                GO,GO,GO
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
