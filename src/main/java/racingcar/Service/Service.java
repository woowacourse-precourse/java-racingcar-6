package racingcar.Service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.Domain.ProgressBoard;
import racingcar.Domain.ProgressDto;
import racingcar.Utils.NumberGenerator;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Service {
    private final ProgressBoard progressBoard;
    private final int GO_NUMBER = 4;
    private List<String> cars;

    public Service(ProgressBoard progressBoard) {
        this.progressBoard = progressBoard;
    }

    public void registerCars(List<String> cars) {
        this.cars = cars;
        progressBoard.registerCars(cars);
    }

    public void executeOneGame() {
        for (String car : cars) {
            if (isRandomNumOverFour()) {
                moveForward(car);
            }
        }
    }

    public List<ProgressDto> getAllProgressOfCar() {
        List<ProgressDto> progresses = new ArrayList<>();
        for (String car : cars) {
            progresses.add(new ProgressDto(car, progressBoard.progressOf(car)));
        }
        return progresses;
    }

    public List<String> getWinners() {
        int maxMove = getMaxMove();
        List<String> winners = new ArrayList<>();
        for (String car : cars) {
            if (progressBoard.progressOf(car).length() == maxMove) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void cleanProgressBoard() {
        this.progressBoard.clear();
    }

    private void moveForward(String carName) {
        progressBoard.moveForward(carName);
    }

    private boolean isRandomNumOverFour() {
        return NumberGenerator.getRandomNumberFromZeroToNine() >= GO_NUMBER;
    }

    private int getMaxMove() {
        int result = 0;
        for (String key : progressBoard.getParticipants()) {
            result = Math.max(result, progressBoard.progressOf(key).length());
        }
        return result;
    }
}
