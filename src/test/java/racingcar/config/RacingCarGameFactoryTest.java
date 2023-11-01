package racingcar.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCarGame;

class RacingCarGameFactoryTest {

    @Test
    void RacingCarGame_클래스_싱글톤_생성_테스트() {
        // given
        RacingCarGame singletonRacingCarGame1 = RacingCarGameFactory.createSingletonRacingCarGame();
        RacingCarGame singletonRacingCarGame2 = RacingCarGameFactory.createSingletonRacingCarGame();
        RacingCarGame singletonRacingCarGame3 = RacingCarGameFactory.createSingletonRacingCarGame();
        RacingCarGame singletonRacingCarGame4 = RacingCarGameFactory.createSingletonRacingCarGame();

        // when
        // then
        Assertions.assertThat(singletonRacingCarGame1)
                .isSameAs(singletonRacingCarGame2)
                .isSameAs(singletonRacingCarGame3)
                .isSameAs(singletonRacingCarGame4)
        ;
    }

}