package racingcar.event.part;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.data.DataStore;
import racingcar.event.core.EventListener.ReturnEvent;
import racingcar.strategy.RacingCarMoveStrategy;
import racingcar.view.part.RaceGameComponent.RaceGameResult;
import racingcar.view.part.RaceGameComponent.RaceGameResult.TrackPerResult;

public record RaceGameEvent(DataStore dataStore) implements ReturnEvent<RaceGameResult> {


    @Override
    public RaceGameResult execute() {
        final var extractTrack = dataStore.findExtractTrack();
        if (extractTrack.isCompleted()) {
            return new RaceGameResult(true, List.of());
        }

        final RacingCarMoveStrategy racingCarMoveStrategy = () -> Randoms.pickNumberInRange(0, 9) <= 4;
        final var participants = dataStore.findParticipants();
        final var savedParticipants = dataStore.saveParticipants(participants.moveAll(racingCarMoveStrategy));
        dataStore.saveExtractTrack(extractTrack.consumerCount());

        return new RaceGameResult(extractTrack.isCompleted(), savedParticipants.cars()
                .stream()
                .map(car -> new TrackPerResult(car.getName(), car.getLap()))
                .toList());
    }
}
