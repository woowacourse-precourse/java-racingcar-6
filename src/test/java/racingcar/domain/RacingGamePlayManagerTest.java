package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.RacingCar;
import domain.RacingGamePlayManager;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGamePlayManagerTest {
    private RacingGamePlayManager racingGamePlayManager;

    @BeforeEach
    void setUp() {
        racingGamePlayManager = new RacingGamePlayManager();
    }

    @Test
    @DisplayName("랜덤 값이 4 이상일 때 자동차를 전진시킨다.")
    void 랜덤값_4이상_전진() {
        // given
        int moveCount = 0;
        int randomValueInRange = 4;
        RacingCar racingCar = new RacingCar("jong", moveCount);

        // when
        racingGamePlayManager.moveOrStayRacingCars(racingCar, randomValueInRange);

        // then
        assertThat(racingCar.getMoveCount()).isEqualTo(moveCount + 1);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만일 때 자동차를 전진시키지 않는다.")
    void 랜덤값_4미만_정지() {
        // given
        int moveCount = 0;
        int randomValueInRange = 3;
        RacingCar racingCar = new RacingCar("jong", moveCount);

        // when
        racingGamePlayManager.moveOrStayRacingCars(racingCar, randomValueInRange);

        // then
        assertThat(racingCar.getMoveCount()).isEqualTo(moveCount);
    }

    @Test
    @DisplayName("차량의 이동 결과를 출력한다.")
    void 차량_움직인만큼_심볼출력() {
        // given
        RacingCar racingCar = new RacingCar("jong", 2);

        // when
        String moveResult = racingGamePlayManager.getMoveResult(racingCar);

        // then
        assertThat(moveResult).isEqualTo("jong : --");
    }

    @Test
    @DisplayName("최종 우승자가 한 명일 때 출력")
    void 최종우승자_한명() {
        // given
        Set<RacingCar> racingCarSet = new LinkedHashSet<>(Arrays.asList(
                new RacingCar("jong1", 1),
                new RacingCar("jong2", 2),
                new RacingCar("jong3", 3)
        ));

        // when
        String racingGameResult = racingGamePlayManager.getRacingGameResult(racingCarSet);

        // then
        assertThat(racingGameResult).isEqualTo("최종 우승자 : jong3");
    }

    @Test
    @DisplayName("최종 우승자가 여러 명일 때 출력")
    void 최종우승자_여러명() {
        // given
        Set<RacingCar> racingCarSet = new LinkedHashSet<>(Arrays.asList(
                new RacingCar("jong1", 1),
                new RacingCar("jong2", 3),
                new RacingCar("jong3", 3)
        ));

        // when
        String racingGameResult = racingGamePlayManager.getRacingGameResult(racingCarSet);

        // then
        assertThat(racingGameResult).isEqualTo("최종 우승자 : jong2, jong3");
    }
}