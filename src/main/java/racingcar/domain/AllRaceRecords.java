package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AllRaceRecords implements Iterable<RaceRecord> {
    List<RaceRecord> allRecords;

    public AllRaceRecords() {
    }

    public AllRaceRecords(List<RaceRecord> allRecords) {
        this.allRecords = new ArrayList<>(allRecords);
    }

    public List<RaceRecord> getAllRecords() {
        return Collections.unmodifiableList(allRecords);
    }

    @Override
    public Iterator<RaceRecord> iterator() {
        return allRecords.iterator();
    }
}
