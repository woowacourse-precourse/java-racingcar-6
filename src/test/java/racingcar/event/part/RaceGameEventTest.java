package racingcar.event.part;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.data.RacingCarRepository;
import racingcar.domain.ExtractTrack;
import racingcar.domain.Participants;
import racingcar.dto.RaceGameResult;
import racingcar.dto.RaceGameResult.TrackPerResult;
import racingcar.strategy.FakeRacingCarMoveStrategy;

@DisplayName("[이벤트] 경주 진행 이벤트에서 ")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RaceGameEventTest {

    private RacingCarRepository racingCarRepository;
    private RaceGameEvent raceGameEvent;

    @BeforeEach
    void setup() {
        this.racingCarRepository = new RacingCarRepository();
        this.raceGameEvent = new RaceGameEvent(this.racingCarRepository);
    }

    @Test
    void _트랙을_한번_돌아간_이후_결과를_반환합니다() {
        //given
        final var participants = Participants.of(List.of("테스트1", "테스트2"));
        final var fakeRacingCarMoveStrategy = new FakeRacingCarMoveStrategy(true, true);
        final var track = new ExtractTrack(2);

        final var expected = RaceGameResult.processGameResult(List.of(
                new TrackPerResult("테스트1", 1),
                new TrackPerResult("테스트2", 1)
        ));

        racingCarRepository.save(participants);
        racingCarRepository.save(track);

        //when
        final var result = raceGameEvent.execute(fakeRacingCarMoveStrategy);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void _잔여_트랙이_없다면_동작하지_않습니다() {
        //given
        final var track = new ExtractTrack(0);
        final var expected = RaceGameResult.createAlreadyCompletedResult();

        racingCarRepository.save(track);

        //when
        final var result = raceGameEvent.execute(() -> true);

        assertThat(result).isEqualTo(expected);
    }

}