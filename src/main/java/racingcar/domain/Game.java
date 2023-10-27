package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int gameTurns;
    private List<Car> cars = new ArrayList<>();

    public void run() {

    }

    public String inputCarNames() {
        String carNames = Console.readLine();
        checkValidCarNames(carNames);
        return carNames;
    }

    private void checkValidCarNames(String input) {

    }

    private void initCarList(String[] carNames) {
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
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
