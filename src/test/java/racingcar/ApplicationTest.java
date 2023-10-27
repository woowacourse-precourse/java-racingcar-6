package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.control.GameProcess;
import racingcar.domain.CreateRandomNum;
import racingcar.domain.GameHost;
import racingcar.domain.JudgeStandard;
import racingcar.domain.RaceCar;
import racingcar.view.GameStart;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static String[] nameArr;
    private static List<RaceCar> raceCarList;

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

        nameArr = new String[]{"one", "two", "three"};

        raceCarList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            raceCarList.add(new RaceCar(nameArr[i]));
        }
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
    // ================ RaceCar.class ================
    @DisplayName("자동차의 이동을 제어해준다.")
    @Test
    public void movementControlCarTest() throws Exception {
        // given


        // when
        raceCarList.get(0).movementControlCar();
        raceCarList.get(0).movementControlCar();
        raceCarList.get(0).movementControlCar();
        raceCarList.get(1).movementControlCar();
        raceCarList.get(1).movementControlCar();
        raceCarList.get(2).movementControlCar();

        Integer result_one = raceCarList.get(0).getCntMovementOfCar();
        Integer result_two = raceCarList.get(1).getCntMovementOfCar();
        Integer result_three = raceCarList.get(2).getCntMovementOfCar();

        // then
        assertThat(result_one).isEqualTo(3);
        assertThat(result_two).isEqualTo(2);
        assertThat(result_three).isEqualTo(1);
    }


    // 추가 완료 - 박승찬

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
