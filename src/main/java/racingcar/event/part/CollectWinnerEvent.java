package racingcar.event.part;

import java.util.List;
import racingcar.data.RacingCarRepository;
import racingcar.event.core.EventListener.ReturnEvent;

public record CollectWinnerEvent(RacingCarRepository racingCarRepository) implements ReturnEvent<List<String>> {

    @Override
    public List<String> execute() {
        return racingCarRepository.findParticipants()
                .collectWinnerNames();
    }
}
