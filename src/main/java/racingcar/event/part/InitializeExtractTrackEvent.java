package racingcar.event.part;

import racingcar.data.DataStore;
import racingcar.domain.ExtractTrack;
import racingcar.event.core.EventListener.ParameterEvent;

public record InitializeExtractTrackEvent(DataStore dataStore) implements ParameterEvent<Integer> {
    @Override
    public void execute(Integer input) {
        dataStore.saveExtractTrack(new ExtractTrack(input));
    }
}
