package racingcar.view;

import java.util.List;
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
        System.out.println();
    }

    public void printWinner(Race race) {
        List<String> winnerNames = race.getWinnerNames();
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
