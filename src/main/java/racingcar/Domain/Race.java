package racingcar.Domain;

public class Race {
    private final int raceTime;

    private Race(final int raceTime){
        this.raceTime = raceTime;
    }

    public boolean runningTime(int race) {
        return race != this.raceTime;
    }
}
