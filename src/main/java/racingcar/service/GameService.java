package racingcar.service;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

import static racingcar.domain.Message.*;

public class GameService {
    private int progressCount;
    private final List<Car> carList = new ArrayList<>();

    public GameService() {
    }

    public void readCarNameList() {
        OutputView.println(READ_CAR_NAME.getMessage());
        InputView.readCarNameList().forEach(carName -> carList.add(new Car(carName)));
    }

    public void readProgressCount() {
        OutputView.println(READ_PROGRESS_COUNT.getMessage());
        progressCount = InputView.readProgressCount();
    }

    public void progressGame() {
        OutputView.print(EXECUTION_RESULT.getProgressMessage(runCarMessage()));
    }

    private StringBuilder runCarMessage() {
        StringBuilder carNameAndAdvanceMarkMessage = new StringBuilder();
        int checkCount = 0;
        while(checkCount != progressCount) {
            checkCount++;
            carList.forEach(
                    car -> carNameAndAdvanceMarkMessage
                            .append(car.getName())
                            .append(" : ")
                            .append(car.getAdvanceCountMark())
                            .append("\n")
            );
            carNameAndAdvanceMarkMessage.append("\n");
        }

        return carNameAndAdvanceMarkMessage;
    }

    public void finishGame() {
        List<String> winnerCarNameList = getWinnerCarNameList();
        OutputView.print(GAME_TOTAL_RESULT.getWinnerMessage(winnerCarNameList));
    }

    private List<String> getWinnerCarNameList() {
        List<String> result = new ArrayList<>();
        int max = -1;
        for (Car car : carList) {
            if (car.getAdvanceCount() > max) {
                max = car.getAdvanceCount();
                result.clear();
                result.add(car.getName());
            } else if (car.getAdvanceCount() == max) {
                result.add(", " + car.getName());
            }
        }

        return result;
    }
}
