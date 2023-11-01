package racingcar.game;

import racingcar.car.Car;
import racingcar.round.Round;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.game.GamePhrases.*;

public class Game {
    private String carNames;
    private String numberOfTry;
    private int tryNumber;

    public void setGame() {
        printPhrasesCarName();
        inputCarName();
        printPhraseNumberOfTry();
        inputNumberOfTry();
        initRound();
    }

    public void startGame(List<Car> cars) throws IllegalArgumentException {
        printPhrasesGameStart();

        while (tryNumber --> 0) {
            Round round = new Round(cars);
            round.startRound();
        }

        printPhrasesWinner(getWinner(cars));
    }

    private void printPhrasesCarName() {
        System.out.println(PHRASES_INPUT_CAR_NAME);
    }

    private void inputCarName() {
        carNames = readLine();
    }

    private void printPhraseNumberOfTry() {
        System.out.println(PHRASES_INPUT_NUMBER_OF_TRY);
    }

    private void inputNumberOfTry() {
        numberOfTry = readLine();
    }

    public List<Car> makeCarEntity() throws IllegalArgumentException{
        List<Car> cars = new ArrayList<>();

        for (String name : carNames.split(",")) {
            if (!checkDuplicationName(cars, name)) throw new IllegalArgumentException();
            else cars.add(new Car(name));
        }

        return cars;
    }

    private boolean checkDuplicationName(List<Car> cars, String carName) {
        for (Car car : cars) {
            if (car.getCarName().equals(carName)) return false;
        }

        return true;
    }

    private void initRound() throws IllegalArgumentException {
        if (!checkNumberOfTry()) throw new IllegalArgumentException();

        tryNumber = Integer.parseInt(numberOfTry);
    }

    private boolean checkNumberOfTry() {
        try {
            Integer.parseInt(numberOfTry);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private String getWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();

        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getCarDistance() > maxDistance) {
                maxDistance = car.getCarDistance();
                winner.clear();
                winner.add(car.getCarName());
            }
            else if (car.getCarDistance() == maxDistance) {
                winner.add(car.getCarName());
            }
        }

        return String.join(",", winner);
    }

    private void printPhrasesWinner(String winner) {
        System.out.println(PHRASES_GAME_WINNER + winner);
    }

    private void printPhrasesGameStart() {
        System.out.println(PHRASES_OUTPUT_GAME_START);
    }
}
