package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.RacingCar;
import domain.RacingGamePlayManager;
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
}