package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import service.RacingCarGameLogic;

public class OutputTest extends NsTest {
    RacingCarGameLogic racingCarGameLogic=new RacingCarGameLogic();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void 공동_우승자_출력_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : -", "woni : "," " ,
                            "pobi : --", "woni : -"," " ,
                            "pobi : --", "woni : --"," " ,
                            "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 둘다_전진하지_않아도_공동_우승자_출력_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

