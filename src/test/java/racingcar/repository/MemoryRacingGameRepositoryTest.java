package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.configuration.AppConfig;
import racingcar.configuration.Config;
import racingcar.domain.racing.Participations;
import racingcar.domain.racing.RacingGame;
import racingcar.domain.racing.TryCount;
import racingcar.domain.racing.Winners;


public class MemoryRacingGameRepositoryTest {

    Config config = AppConfig.getInstance();
    private RacingGameRepository racingGameRepository = config.racingRepository();
    Participations participations = Participations.create(new ArrayList<>());
    TryCount tryCount = TryCount.create("5");
    Winners winners = Winners.createEmpty();

    @BeforeEach
    public void setUp() {
        racingGameRepository.deleteAll();
    }

    @Test
    public void 새로운_Racing저장() {
        // given
        RacingGame racingGame = RacingGame.create(participations, tryCount, winners);

        // when
        final RacingGame result = (RacingGame) racingGameRepository.save(racingGame);

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getParticipationsList()).isSameAs(participations.getParticipations());
        assertThat(result.getTryCount()).isEqualTo(5);
    }

}
