package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static final String CAR_NAME_DELIMIT = ",";
    private static final String SPACE = " ";

    private List<Car> cars;
    private StringBuilder gameLog;
    private StringBuilder gameWinner;
    private Integer attemptCount;

    public GameManager() {
        this.cars = new ArrayList<>();
        this.gameLog = new StringBuilder();
        this.gameWinner = new StringBuilder();
        this.attemptCount = 0;
    }

    public void readCarNames() {
        String enteredCarNames = Console.readLine();
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
        if (cars.size() <= 1) {
            throw new IllegalArgumentException("최소 1대의 자동차가 입력되어야 합니다.");
        }
    }

    private void checkBlankName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 공란입니다.");
        }
    }

    private void checkNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void readAttemptCount() {
        int enteredAttemptCount = Integer.parseInt(Console.readLine());

        this.attemptCount = enteredAttemptCount;
    }

    public void startGame() {
        for (int count = 0; count < attemptCount; count++) {
            for (Car car : cars) {
                car.decideMoveOrNot();
                gameLog.append(car.getCurrentStatus()).append(View.NEW_LINE);
            }
            gameLog.append(View.NEW_LINE);
        }
    }

    public void calculateWinner() {
        cars.sort((car1, car2) -> car2.getScore() - car1.getScore());
        Car winner = cars.get(0);
        gameWinner.append(winner);
        findCoWinner(winner);
    }

    private void findCoWinner(Car winner) {
        for (int index = 1; index < cars.size(); index++) {
            Car car = cars.get(index);
            if (winner.getScore() != car.getScore()) {
                break;
            }
            gameWinner.append(CAR_NAME_DELIMIT).append(SPACE).append(car);
        }
    }

    public String getGameLog() {
        return gameLog.toString();
    }

    public String getGameWinner() {
        return gameWinner.toString();
    }
}
