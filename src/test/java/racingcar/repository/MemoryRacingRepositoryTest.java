package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.configuration.AppConfig;
import racingcar.configuration.Config;
import racingcar.domain.Participations;
import racingcar.domain.Racing;
import racingcar.domain.Winners;


public class MemoryRacingRepositoryTest {

    Config config = AppConfig.getInstance();
    private RacingRepository racingRepository = config.racingRepository();
    Participations participations = new Participations();
    int tryCount = 5;
    Winners winners = new Winners();

    @BeforeEach
    public void setUp() {
        racingRepository.deleteAll();
    }

    @Test
    public void 새로운_Racing저장() {
        // given
        Racing racing = Racing.create(participations, tryCount);

        // when
        final Racing result = (Racing) racingRepository.save(racing);

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getParticipations()).isSameAs(participations);
        assertThat(result.getTryCount()).isEqualTo(tryCount);
    }

    @Test
    public void Winners_업데이트() {
        // given
        Racing racing = Racing.create(participations, tryCount);
        racingRepository.save(racing);
        Long id = racing.getId();

        // when
        final Racing result = (Racing) racingRepository.updateWinners(
                id, winners);

        // then
        assertThat(result.getWinners()).isSameAs(winners);
    }


}
