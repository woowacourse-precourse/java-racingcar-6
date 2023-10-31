package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceEntry {
    private final List<Car> raceEntryList;

    public RaceEntry(List<String> carNames) {
        raceEntryList = new ArrayList<>();

        for (String token : carNames) {
            raceEntryList.add(new Car(token));
        }

    }

    public List<Car> getRaceEntryList() {
        return raceEntryList;
    }

}
