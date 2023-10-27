package racingcar.component;

public class RaceSimulator {
    private RaceSimulator() {}

    private static RaceSimulator raceSimulator;

    public static RaceSimulator getRaceSimulator() {
        if (raceSimulator == null) {
            raceSimulator = new RaceSimulator();
        }
        return raceSimulator;
    }

}
