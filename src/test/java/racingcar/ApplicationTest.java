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
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 전진_정지_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 전진_정지_3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 전진_정지_4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP, STOP, STOP
        );
    }

    @Test
    void 전진_정지_5() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "5");
                    assertThat(output()).contains("pobi : ----", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 전진_정지_6() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,seung,chan,win", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ", "seung : ---", "chan : ---", "win : ---", "최종 우승자 : pobi, seung, chan, win");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 전진_정지_7() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : -", "woni : --", "최종 우승자 : woni");
                },
                STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
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
        firstRaceCar.movementControl(4);
        firstRaceCar.movementControl(5);
        firstRaceCar.movementControl(6);

        secondRaceCar.movementControl(7);
        secondRaceCar.movementControl(8);
        secondRaceCar.movementControl(1);

        thirdRaceCar.movementControl(9);
        thirdRaceCar.movementControl(2);
        thirdRaceCar.movementControl(3);

        Integer result_one = raceCarList.get(0).getCntMovement();
        Integer result_two = raceCarList.get(1).getCntMovement();
        Integer result_three = raceCarList.get(2).getCntMovement();

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

        Integer result_one = raceCarList.get(0).getCntMovement();
        Integer result_two = raceCarList.get(1).getCntMovement();
        Integer result_three = raceCarList.get(2).getCntMovement();

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
        firstRaceCar.movementControl(4);
        firstRaceCar.movementControl(5);
        firstRaceCar.movementControl(6);

        secondRaceCar.movementControl(7);
        secondRaceCar.movementControl(8);
        secondRaceCar.movementControl(1);

        thirdRaceCar.movementControl(2);
        thirdRaceCar.movementControl(3);
        thirdRaceCar.movementControl(4);

        winRaceCarList = gameHost.giveWinnerList(raceCarList);
        String result = winRaceCarList.get(0).toString();

        // then
        assertThat(result).isEqualTo("one");
    }

    // ================ JudgeStandard.class ================
    @DisplayName("자동차중에 전진을 한 숫작 5개이면 승리를 한것이다.")
    @Test
    public void isVictoryConditionTest() throws Exception {
        // given

        // when
        firstRaceCar.movementControl(4);
        firstRaceCar.movementControl(5);
        firstRaceCar.movementControl(6);

        secondRaceCar.movementControl(7);
        secondRaceCar.movementControl(8);
        secondRaceCar.movementControl(1);

        boolean result_true = judgeStandard.isVictory(firstRaceCar, 3);
        boolean result_false = judgeStandard.isVictory(secondRaceCar, 3);

        // then
        assertThat(result_true).isTrue();
        assertThat(result_false).isFalse();

    }

    // 추가 완료 - 박승찬

    // 테스트 할시 main 함수를 하는 방법
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
