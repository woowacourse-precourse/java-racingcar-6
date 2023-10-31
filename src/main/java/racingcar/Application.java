package racingcar;

public class Application {
    public static void main(String[] args) {
        RaceManager raceManager = RaceManager.setUp(Race.toRaceManager());
        raceManager.run();
    }
}
