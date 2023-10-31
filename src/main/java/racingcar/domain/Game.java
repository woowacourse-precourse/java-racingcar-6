package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private int gameTurns;
    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    public void init() {
        Logs.inputCarNames();
        String[] carNames = inputCarNames();
        initCarList(carNames);

        Logs.inputGameTurns();
        inputGameTurns();
        Logs.newLine();
    }

    public void run() {
        Logs.getGameResult();

        for (int i = 0; i < gameTurns; i++) {
            for (Car car : cars) {
                int randomNumber = RandomMaker.makeRandomNumber();
                car.move(randomNumber);
                Logs.car(car);
            }
            Logs.newLine();
        }
    }

    public void finish() {
        findWinners();
        Logs.string(winnersToString());
    }

    public String[] inputCarNames() {
        String[] carNames = Arrays.stream(Console.readLine().split(",", -1))
                                    .sequential()
                                    .map(String::strip)
                                    .toArray(String[]::new);
        checkValidCarNames(carNames);
        return carNames;
    }

    private void checkValidCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.isBlank() || carName.length() > 5) {
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
        String input = Console.readLine().strip();
        checkValidGameTurns(input);
        gameTurns = Integer.parseInt(input);
    }

    private void checkValidGameTurns(String input) {
        try {
            int number = Integer.parseInt(input);

            if (number < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not valid input: game turn number");
        }
    }

    public void findWinners() {
        int maxDistance = -1;

        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
    }

    public String winnersToString() {
        return "최종 우승자 : " + String.join(", ", winners);
    }
}
