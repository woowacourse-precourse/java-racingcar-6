package racingcar.event.part;

import racingcar.data.RacingCarRepository;
import racingcar.domain.ExtractTrack;
import racingcar.event.core.EventListener.ParameterEvent;

public record InitializeExtractTrackEvent(RacingCarRepository racingCarRepository) implements ParameterEvent<Integer> {
    @Override
    public void execute(Integer input) {
        racingCarRepository.save(new ExtractTrack(input));
    }
}
