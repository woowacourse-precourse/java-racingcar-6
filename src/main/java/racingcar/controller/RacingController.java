package racingcar.controller;

import racingcar.model.CarInput;
import racingcar.model.CarMap;
import racingcar.model.RacingCar;
import racingcar.model.RoundCountInput;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 레이싱을 진행시키는 클래스다.
 *
 * @author haiseong
 */
public class RacingController {
    private final CarMap carMap;

    public RacingController() {
        this.carMap = new CarMap();
    }

    /**
     * 레이싱을 진행한다.
     */
    public void playRacing() {
        initializeCarMap();
        int roundCount = getRoundCount();
        executeRounds(roundCount);
        displayWinners();
    }

    private void initializeCarMap() {
        OutputView.printCarInputMessage();
        CarInput carInput = new CarInput(InputView.readLine());
        List<String> nameList = carInput.getNameList();
        for (String name : nameList) {
            carMap.add(name);
        }
    }

    private int getRoundCount() {
        OutputView.printRoundCountInputMessage();
        RoundCountInput roundCountInput = new RoundCountInput(InputView.readLine());
        return roundCountInput.getRoundCount();
    }

    private void executeRounds(int roundCount) {
        OutputView.printExecuteResultMessage();
        for (int i = 0; i < roundCount; i++) {
            carMap.executeRound();
            displayRoundResults();
            OutputView.println();
        }
    }

    private void displayRoundResults() {
        Iterator<Map.Entry<String, RacingCar>> carMapIterator = carMap.getIterator();
        while (carMapIterator.hasNext()) {
            Map.Entry<String, RacingCar> carEntry = carMapIterator.next();
            String name = carEntry.getKey();
            RacingCar racingCar = carEntry.getValue();
            OutputView.printDistanceMarker(name, racingCar.getDistance());
        }
    }

    private void displayWinners() {
        OutputView.printWinnersMessage(carMap.getWinners());
    }
}
