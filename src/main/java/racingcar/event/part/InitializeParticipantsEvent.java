package racingcar.event.part;

import java.util.List;
import racingcar.data.DataStore;
import racingcar.domain.Participants;
import racingcar.event.core.EventListener.ParameterEvent;

public record InitializeParticipantsEvent(DataStore dataStore) implements ParameterEvent<List<String>> {
    @Override
    public void execute(List<String> input) {
        dataStore.saveParticipants(Participants.of(input));
    }
}
