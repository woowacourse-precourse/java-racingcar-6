package racingcar.event.part;

import java.util.List;
import racingcar.data.DataStore;
import racingcar.event.core.EventListener.ReturnEvent;

public record CollectWinnerEvent(DataStore dataStore) implements ReturnEvent<List<String>> {

    @Override
    public List<String> execute() {
        return dataStore.findParticipants().collectWinnerNames();
    }
}
