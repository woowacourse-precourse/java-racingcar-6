package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int gameTurns;
    private List<Car> cars = new ArrayList<>();

    public void run() {

    }

    public void inputCarNames() {
        String carNames = Console.readLine();
        checkValidCarNames(carNames);
        initCarList(carNames.split(","));
    }

    private void checkValidCarNames(String input) {

    }

    private void initCarList(String[] carNames) {

    }

    public void inputGameTurns() {
        try {
            gameTurns = Integer.parseInt(Console.readLine().strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not valid input game turn number");
        }
    }

    public void getWinners() {

    }
}
