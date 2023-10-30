package racingcar.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private String carNames;

    public Game() {
        printPhrasesCarName();
        inputCarName();
    }

    private void printPhrasesCarName() {
        System.out.println(GamePhrases.PHRASES_INPUT_CAR_NAME);
    }

    private void inputCarName() {
        carNames = readLine();
    }
}
