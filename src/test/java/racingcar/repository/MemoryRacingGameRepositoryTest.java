package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.configuration.AppConfig;
import racingcar.configuration.Config;
import racingcar.domain.Participations;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;


public class MemoryRacingGameRepositoryTest {

    Config config = AppConfig.getInstance();
    private RacingGameRepository racingGameRepository = config.racingRepository();
    Participations participations = new Participations();
    int tryCount = 5;
    Winners winners = new Winners();

    @BeforeEach
    public void setUp() {
        racingGameRepository.deleteAll();
    }

    @Test
    public void 새로운_Racing저장() {
        // given
        RacingGame racingGame = RacingGame.create(participations, tryCount);

        // when
        final RacingGame result = (RacingGame) racingGameRepository.save(racingGame);

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getParticipations()).isSameAs(participations);
        assertThat(result.getTryCount()).isEqualTo(tryCount);
    }

    @Test
    public void Winners_업데이트() {
        // given
        RacingGame racingGame = RacingGame.create(participations, tryCount);
        racingGameRepository.save(racingGame);
        Long id = racingGame.getId();

        // when
        final RacingGame result = (RacingGame) racingGameRepository.updateWinners(
                id, winners);

        // then
        assertThat(result.getWinners()).isSameAs(winners);
    }


}
