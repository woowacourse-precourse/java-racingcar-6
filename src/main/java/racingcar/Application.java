package racingcar;

import racingcar.control.Race;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();
        race.start();
        race.setTrial();
        race.running();
        race.lastWinner();
    }
}
