package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Game {
    private int gameTurns;
    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    public void run() {

    }

    public String inputCarNames() {
        String carNames = Console.readLine();
        checkValidCarNames(carNames);
        return carNames;
    }

    private void checkValidCarNames(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        while (tokenizer.hasMoreTokens()) {
            String carName = tokenizer.nextToken();
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException("Not valid input: car names");
            }
        }
    }

    private void initCarList(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void inputGameTurns() {
        try {
            gameTurns = Integer.parseInt(Console.readLine().strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not valid input: game turn number");
        }
    }

    public void findWinners() {

    }
}
