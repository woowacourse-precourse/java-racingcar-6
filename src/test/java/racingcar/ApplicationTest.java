package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.control.GameProcess;
import racingcar.domain.CreateRandomNum;
import racingcar.domain.GameHost;
import racingcar.domain.JudgeStandard;
import racingcar.domain.RaceCar;
import racingcar.view.GameStart;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private GameProcess gameProcess;
    private CreateRandomNum createRandomNum;
    private GameHost gameHost;
    private JudgeStandard judgeStandard;
    private RaceCar raceCar;
    private GameStart gameStart;

    @BeforeEach
    void setup() {
        gameProcess = new GameProcess();
        createRandomNum = new CreateRandomNum();
        gameHost = new GameHost();
        judgeStandard = new JudgeStandard();
        raceCar = new RaceCar();
        gameStart = new GameStart();
    }


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

    // 추가 - 박승찬


    // 추가 완료 - 박승찬

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
