package racingcar.event.part;

import java.util.List;
import racingcar.data.RacingCarRepository;
import racingcar.domain.Participants;
import racingcar.event.core.EventListener.ParameterEvent;

public record InitializeParticipantsEvent(RacingCarRepository racingCarRepository) implements ParameterEvent<List<String>> {
    @Override
    public void execute(List<String> input) {
        racingCarRepository.save(Participants.of(input));
    }
}
