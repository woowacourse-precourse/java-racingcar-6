package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.ErrorMessage.*;

public class GameManager {
    private static final String NEW_LINE = "\n";
    private static final String CAR_NAME_DELIMIT = ",";
    private static final String SPACE = " ";
    private static final Integer MINIMUM_CAR_COUNT = 1;
    private static final Integer MINIMUM_ATTEMPT_COUNT = 1;
    private static final Integer MAXIMUM_CAR_NAME_LENGTH = 5;

    private final NumberGenerator numberGenerator;
    private final GameConsole gameConsole;
    private List<Car> cars;
    private StringBuilder gameLog;
    private StringBuilder gameWinner;
    private Integer attemptCount;

    public GameManager(NumberGenerator numberGenerator, GameConsole gameConsole) {
        this.numberGenerator = numberGenerator;
        this.gameConsole = gameConsole;
        this.cars = new ArrayList<>();
        this.gameLog = new StringBuilder();
        this.gameWinner = new StringBuilder();
        this.attemptCount = 0;
    }

    public void readCarNames() {
        String enteredCarNames = gameConsole.readLine();
        validateCarNames(enteredCarNames);
    }

    private void validateCarNames(String enteredCarNames) {
        String[] carNames = enteredCarNames.split(CAR_NAME_DELIMIT);
        for (String carName : carNames) {
            checkBlankName(carName);
            checkNameLength(carName);
            cars.add(new Car(carName));
        }
        checkCarCount();
    }

    private void checkCarCount() {
        if (cars.size() <= MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(INVALID_MINIMUM_CAR_COUNT.getMessage());
        }
    }

    private void checkBlankName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_IS_BLANK.getMessage());
        }
    }

    private void checkNameLength(String carName) {
        if (carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEEDED_CAR_NAME_LENGTH.getMessage());
        }
    }

    public void readAttemptCount() {
        try {
            attemptCount = Integer.parseInt(gameConsole.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_IS_NOT_NUMBER.getMessage());
        }
        if (attemptCount < MINIMUM_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(INVALID_MINIMUM_ATTEMPT_COUNT.getMessage());
        }
    }

    public void startGame() {
        for (int count = 0; count < attemptCount; count++) {
            for (Car car : cars) {
                int randomNumber = numberGenerator.generate();
                car.decideMoveOrNot(randomNumber);
                gameLog.append(car.getCurrentStatus()).append(NEW_LINE);
            }
            gameLog.append(NEW_LINE);
        }
        calculateWinner();
    }

    private void calculateWinner() {
        int winnerScore = getWinnerScore();
        findWinner(winnerScore);
    }

    private int getWinnerScore() {
        cars.sort((car1, car2) -> car2.getScore() - car1.getScore());

        return cars.get(0).getScore();
    }

    private void findWinner(int winnerScore) {
        for (Car car : cars) {
            if (car.getScore() != winnerScore) {
                break;
            }
            if (!gameWinner.isEmpty()) {
                gameWinner.append(CAR_NAME_DELIMIT).append(SPACE);
            }
            gameWinner.append(car);
        }
    }

    public String getGameLog() {
        return gameLog.toString();
    }

    public String getGameWinner() {
        return gameWinner.toString();
    }
}
