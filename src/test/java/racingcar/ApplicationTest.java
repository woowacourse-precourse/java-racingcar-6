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
    private static RaceCar firstRaceCar;
    private static RaceCar secondRaceCar;
    private static RaceCar thirdRaceCar;

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

        firstRaceCar = raceCarList.get(0);
        secondRaceCar = raceCarList.get(1);
        thirdRaceCar = raceCarList.get(2);
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
        firstRaceCar.movementControlCar(4);
        firstRaceCar.movementControlCar(5);
        firstRaceCar.movementControlCar(6);

        secondRaceCar.movementControlCar(7);
        secondRaceCar.movementControlCar(8);
        secondRaceCar.movementControlCar(1);

        thirdRaceCar.movementControlCar(9);
        thirdRaceCar.movementControlCar(2);
        thirdRaceCar.movementControlCar(3);

        Integer result_one = raceCarList.get(0).getCntMovementOfCar();
        Integer result_two = raceCarList.get(1).getCntMovementOfCar();
        Integer result_three = raceCarList.get(2).getCntMovementOfCar();

        // then
        assertThat(result_one).isEqualTo(3);
        assertThat(result_two).isEqualTo(2);
        assertThat(result_three).isEqualTo(1);
    }

    @DisplayName("자동차가 전진을 한다.")
    @Test
    public void moveForwardTest() throws Exception {
        // given


        // when
        firstRaceCar.moveForward();
        firstRaceCar.moveForward();
        firstRaceCar.moveForward();

        secondRaceCar.moveForward();
        secondRaceCar.moveForward();

        thirdRaceCar.moveForward();

        Integer result_one = raceCarList.get(0).getCntMovementOfCar();
        Integer result_two = raceCarList.get(1).getCntMovementOfCar();
        Integer result_three = raceCarList.get(2).getCntMovementOfCar();

        // then
        assertThat(result_one).isEqualTo(3);
        assertThat(result_two).isEqualTo(2);
        assertThat(result_three).isEqualTo(1);
    }

    // ================ GameHost.class ================
    @DisplayName("게임을 진행하는 게임 진행자를 생성하는 클래스")
    @Test
    public void winRaceCarTest() throws Exception {
        // given
        List<RaceCar> winRaceCarList = new ArrayList<>();

        // when
        firstRaceCar.movementControlCar();
        firstRaceCar.movementControlCar();
        firstRaceCar.movementControlCar();

        secondRaceCar.movementControlCar();
        secondRaceCar.movementControlCar();

        thirdRaceCar.movementControlCar();

        winRaceCarList = gameHost.winRaceCar(raceCarList);
        String result = winRaceCarList.toString();

        // then
        assertThat(result).isEqualTo(nameArr[0]);
    }

    // ================ JudgeStandard.class ================
    @DisplayName("자동차중에 전진을 한 숫작 5개이면 승리를 한것이다.")
    @Test
    public void isVictoryConditionTest() throws Exception {
        // given

        // when
        firstRaceCar.movementControlCar();
        firstRaceCar.movementControlCar();
        firstRaceCar.movementControlCar();

        secondRaceCar.movementControlCar();
        secondRaceCar.movementControlCar();

        boolean result_true = judgeStandard.isVictoryCondition(firstRaceCar);
        boolean result_false = judgeStandard.isVictoryCondition(secondRaceCar);

        // then
        assertThat(result_true).isTrue();
        assertThat(result_false).isFalse();

    }

    // 추가 완료 - 박승찬

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
