package racingcar.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.race.Race;

class RaceFactoryTest {

    @Test
    void Race_클래스_싱글톤_생성_테스트() {
        // given
        Race singletonRace1 = RaceFactory.createSingletonRace();
        Race singletonRace2 = RaceFactory.createSingletonRace();
        Race singletonRace3 = RaceFactory.createSingletonRace();
        Race singletonRace4 = RaceFactory.createSingletonRace();

        // when
        // then
        Assertions.assertThat(singletonRace1)
                .isSameAs(singletonRace2)
                .isSameAs(singletonRace3)
                .isSameAs(singletonRace4)
        ;
    }

}