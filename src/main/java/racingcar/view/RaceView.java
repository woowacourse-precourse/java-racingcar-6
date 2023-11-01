package racingcar.view;

import racingcar.model.Race;

public class RaceView {
    public RaceView() {
    }

    private String renderCarState(String carName, int distance) {
        return carName + " : " + "-".repeat(distance);
    }

    public void printRace(Race race) {
        for (String name : race.getCarNames()) {
            String renderedCarState = renderCarState(name, race.getDistance(name));
            System.out.println(renderedCarState);
        }
    }
}
