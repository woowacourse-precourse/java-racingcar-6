package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JudgeStandardTest {
    private final int MOVE = 4;
    private RaceCar raceCar_1;
    private JudgeStandard judgeStandard;

    @BeforeEach
    void setUp() {
        raceCar_1 = new RaceCar("fir");
        judgeStandard = new JudgeStandard();
    }

    private void moveRaceCar(RaceCar raceCar) {
        raceCar.movementControl(MOVE);
    }

    @DisplayName("레이스 게임의 승리 여부 확인._1")
    @Test
    void isVictoryCondition_1() {
        // given
        moveRaceCar(raceCar_1);

        // when
        boolean result = judgeStandard.isVictory(raceCar_1, 1);

        // than
        assertThat(result).isTrue();
    }

    @DisplayName("레이스 게임의 승리 여부 확인._2")
    @Test
    void isVictoryCondition_2() {
        // given
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);

        // when
        boolean result = judgeStandard.isVictory(raceCar_1, 2);

        // than
        assertThat(result).isTrue();
    }

    @DisplayName("레이스 게임의 승리 여부 확인._3")
    @Test
    void isVictoryCondition_3() {
        // given
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);

        // when
        boolean result = judgeStandard.isVictory(raceCar_1, 3);

        // than
        assertThat(result).isTrue();
    }
}