package racingcar;

public class Application {

    public static void main(String[] args) {
        CarRaceManager raceManager = new CarRaceManager();
        RaceView raceView = new RaceView(raceManager);
        raceView.start();
    }
}