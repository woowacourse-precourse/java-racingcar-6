package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.array2D;

class GameHostTest {
    private final int MOVE = 4;
    private final int STOP = 1;
    private GameHost gameHost;
    private RaceCar raceCar_1;
    private RaceCar raceCar_2;
    private RaceCar raceCar_3;

    private List<RaceCar> progressRaceCarList;

    @BeforeEach
    void setUp() {
        gameHost = new GameHost();
        raceCar_1 = new RaceCar("fir");
        raceCar_2 = new RaceCar("sec");
        raceCar_3 = new RaceCar("third");
        progressRaceCarList = List.of(raceCar_1, raceCar_2, raceCar_3);
    }

    private void moveRaceCar(RaceCar raceCar) {
        raceCar.movementControl(MOVE);
    }

    private void stopRaceCar(RaceCar raceCar) {
        raceCar.movementControl(STOP);
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._1 ")
    @Test
    void knowWinRaceCarsTest_1() {
        // given
        moveRaceCar(raceCar_1);

        // when
        List<RaceCar> result = gameHost.giveWinnerList(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_1));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._2 ")
    @Test
    void knowWinRaceCarsTest_2() {
        // given
        moveRaceCar(raceCar_2);

        // when
        List<RaceCar> result = gameHost.giveWinnerList(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_2));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._3 ")
    @Test
    void knowWinRaceCarsTest_3() {
        // given
        moveRaceCar(raceCar_3);

        // when
        List<RaceCar> result = gameHost.giveWinnerList(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_3));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._4 ")
    @Test
    void knowWinRaceCarsTest_4() {
        // given
        moveRaceCar(raceCar_1);

        moveRaceCar(raceCar_2);

        // when
        List<RaceCar> result = gameHost.giveWinnerList(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_1, raceCar_2));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._5 ")
    @Test
    void knowWinRaceCarsTest_5() {
        // given
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_2);

        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);

        // when
        List<RaceCar> result = gameHost.giveWinnerList(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_3));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._6 ")
    @Test
    void knowWinRaceCarsTest_6() {
        // given
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);

        moveRaceCar(raceCar_2);
        moveRaceCar(raceCar_2);
        moveRaceCar(raceCar_2);

        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);

        // when
        List<RaceCar> result = gameHost.giveWinnerList(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_1, raceCar_2, raceCar_3));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._7 ")
    @Test
    void knowWinRaceCarsTest_7() {
        // given
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);

        moveRaceCar(raceCar_2);
        moveRaceCar(raceCar_2);
        moveRaceCar(raceCar_2);

        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);

        // when
        List<RaceCar> result = gameHost.giveWinnerList(progressRaceCarList);

        // than
        assertThat(result).containsOnly(raceCar_1, raceCar_2, raceCar_3);
        assertThat(result).containsExactly(raceCar_1, raceCar_2, raceCar_3);
        assertThat(result).allMatch((raceCar -> raceCar.getCntMovement() == 3));
    }

    @DisplayName("현제 레이싱을 하는 자동차의 움직인 횟수중에 최고로 많은 횟수를 알려준다.")
    @Test
    void getCntMaxMoveTest_1() {
        // given
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);

        moveRaceCar(raceCar_2);
        moveRaceCar(raceCar_2);

        moveRaceCar(raceCar_3);

        // when
        Integer result = gameHost.getMaxCntMoveOfRaceCar(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("현제 레이싱을 하는 자동차의 움직인 횟수중에 최고로 많은 횟수를 알려준다._2")
    @Test
    void getCntMaxMoveTest_2() {
        // given
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);

        moveRaceCar(raceCar_2);
        moveRaceCar(raceCar_2);

        moveRaceCar(raceCar_3);

        // when
        Integer result = gameHost.getMaxCntMoveOfRaceCar(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(2);
    }


    @DisplayName("현제 레이싱을 하는 자동차의 움직인 횟수중에 최고로 많은 횟수를 알려준다._3")
    @Test
    void getCntMaxMoveTest_3() {
        // given
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);

        // when
        Integer result = gameHost.getMaxCntMoveOfRaceCar(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("현제 레이싱을 하는 자동차의 움직인 횟수중에 최고로 많은 횟수를 알려준다._4")
    @Test
    void getCntMaxMoveTest_4() {
        // given
        moveRaceCar(raceCar_2);
        moveRaceCar(raceCar_2);
        moveRaceCar(raceCar_2);

        // when
        Integer result = gameHost.getMaxCntMoveOfRaceCar(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("현제 레이싱을 하는 자동차의 움직인 횟수중에 최고로 많은 횟수를 알려준다._5")
    @Test
    void getCntMaxMoveTest_5() {
        // given
        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);

        // when
        Integer result = gameHost.getMaxCntMoveOfRaceCar(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("게임승자을 알수있다.")
    @Test
    public void 게임승자를_알수있는_테스() throws Exception {
        // given
        List<RaceCar> list = List.of(raceCar_1, raceCar_2, raceCar_3);
        List<RaceCar> winners = new ArrayList<>();

        // when
        for (int i = 0; i < 3; i++) {
            list.forEach(raceCar -> raceCar.moveForward());
        }
        winners = gameHost.giveWinnerList(list);

        // then
        assertThat(winners).extracting(RaceCar::toString)
                .containsOnly(raceCar_1.toString(), raceCar_2.toString(), raceCar_3.toString());
    }

    @DisplayName("게임승자을 알수있다.")
    @Test
    public void 게임승자를_알수있는_테스트_2() throws Exception {
        // given
        List<RaceCar> list = List.of(raceCar_1, raceCar_2, raceCar_3);
        List<RaceCar> winners = new ArrayList<>();

        // when
        winners = gameHost.giveWinnerList(list);

        // then
        assertThat(winners).extracting(RaceCar::toString)
                .containsOnly(raceCar_1.toString(), raceCar_2.toString(), raceCar_3.toString());
    }
}