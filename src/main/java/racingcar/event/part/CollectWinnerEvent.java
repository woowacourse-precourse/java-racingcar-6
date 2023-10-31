package racingcar.event.part;

import java.util.List;
import racingcar.data.DataStore;
import racingcar.domain.Car;
import racingcar.event.core.EventListener.ReturnEvent;

public record CollectWinnerEvent(DataStore dataStore) implements ReturnEvent<List<String>> {

    @Override
    public List<String> execute() {
        final var maxLap = dataStore.findParticipants().cars()
                .stream().mapToInt(Car::getLap)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return dataStore.findParticipants().cars()
                .stream().filter(car -> car.getLap() == maxLap)
                .map(Car::getName)
                .toList();

    }
}
