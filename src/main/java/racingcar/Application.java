package racingcar;

import race.Race;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.startMessage();
        Race race = new Race();

        OutputView.askTryNumber();
        race.run();
    }
}
