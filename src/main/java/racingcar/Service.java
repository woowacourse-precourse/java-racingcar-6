package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.Utils.NumberGenerator;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Service {
    private final ProgressBoard progressBoard;
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private final int GO_NUMBER = 4;
    private List<String> cars;

    public Service() {
        this.progressBoard = ProgressBoard.getInstance();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = new NumberGenerator();
    }

    public String receiveCars() {
        inputView.printCarNameMessage();
        String input = Console.readLine();
        return input;
    }

    public String receiveTrialCount() {
        inputView.printTryCountMessage();
        String input = Console.readLine();
        return input;
    }

    public void registerCars(List<String> cars) {
        this.cars = cars;
        progressBoard.registerCars(cars);
    }

    public void executeOneGame() {
        for (String car : cars) {
            if (canMoveForward()) {
                moveForward(car);
            }
        }
    }

    private void moveForward(String carName) {
        progressBoard.moveForward(carName);
    }

    private boolean canMoveForward() {
        return numberGenerator.getRandomNumber() >= GO_NUMBER;
    }

    public void showProgress() {
        outputView.printProgressMessage(cars, progressBoard);
    }

    public void printResultMessage() {
        outputView.printResultMessage();
    }

    public void showFinalWinner() {
        List<String> winners = getWinners();
        outputView.printFinalWinner(winners);
    }

    private List<String> getWinners() {
        int maxMove = getMaxMove();
        List<String> winners = new ArrayList<>();
        for (String car : cars) {
            if (progressBoard.progressOf(car).length() == maxMove) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxMove() {
        int result = 0;
        for (String key : progressBoard.getParticipants()) {
            result = Math.max(result, progressBoard.progressOf(key).length());
        }
        return result;
    }
}
