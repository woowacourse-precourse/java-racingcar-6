package racingcar;

import racingcar.race.DiceNumber;
import racingcar.race.Race;
import racingcar.race.RandomNumber;
import racingcar.race.Run;
import racingcar.view.Input;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Input input = new Input();
        RandomNumber randomNumber = new RandomNumber();
        DiceNumber diceNumber = new DiceNumber(randomNumber);
        Race race = new Race(diceNumber);
        Run run = new Run(input, race);

    }
}
