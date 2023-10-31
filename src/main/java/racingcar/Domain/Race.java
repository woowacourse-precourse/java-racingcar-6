package racingcar.Domain;

public class Race {
    private final int raceCount;

    public Race(final int raceCount){
        this.raceCount = raceCount;
    }

    public int getRaceCount() {
        return this.raceCount;
    }

    public boolean isRaceOver(int race) {
        return race == this.raceCount;
    }

}
