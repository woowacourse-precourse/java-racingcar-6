package domain;

import ui.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceResult {
    private List<RaceStatus> raceResult;

    public RaceResult() {
        this.raceResult = new ArrayList<>();
    }

    public void add(RaceStatus newRaceStatus) {
        Output.printRacingStatus(newRaceStatus);
        raceResult.add(newRaceStatus);
    }

    public List<Car> getWinner() {
        final int lastResult = raceResult.size() - 1;
        return raceResult.get(lastResult).getWinner();
    }

    public List<RaceStatus> getRaceResult() {
        return raceResult;
    }
}
