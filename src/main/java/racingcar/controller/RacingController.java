package racingcar.controller;

import racingcar.model.CarInput;
import racingcar.model.CarList;
import racingcar.model.RacingCar;
import racingcar.model.RoundCountInput;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.Iterator;
import java.util.List;

/**
 * RacingController는 레이싱을 진행시키는 클래스다.
 *
 * @author haiseong
 */
public class RacingController {
    private final CarList carList;

    public RacingController() {
        this.carList = new CarList();
    }

    /**
     * 레이싱을 진행한다.
     */
    public void playRacing() {
        initializeCarList();
        int roundCount = getRoundCount();
        executeRounds(roundCount);
        displayWinners();
    }

    /**
     * 자동차 이름에 대한 입력을 carList에 저장한다.
     */
    private void initializeCarList() {
        OutputView.printCarInputMessage();
        CarInput carInput = new CarInput(InputView.readLine());
        List<String> nameList = carInput.getNameList();
        for (String name : nameList) {
            carList.add(name);
        }
    }

    /**
     * 차수 입력을 리턴한다.
     *
     * @return 차수
     */
    private int getRoundCount() {
        OutputView.printRoundCountInputMessage();
        RoundCountInput roundCountInput = new RoundCountInput(InputView.readLine());
        return roundCountInput.getRoundCount();
    }

    /**
     * 차수 만큼 라운드를 진행한다.
     *
     * @param roundCount 차수
     */
    private void executeRounds(int roundCount) {
        OutputView.printExecuteResultMessage();
        for (int i = 0; i < roundCount; i++) {
            carList.executeRound();
            displayRoundResults();
            OutputView.println();
        }
    }

    /**
     * 수행 결과를 출력한다.
     */
    private void displayRoundResults() {
        Iterator<RacingCar> carIterator = carList.getIterator();
        while (carIterator.hasNext()) {
            RacingCar racingCar = carIterator.next();
            OutputView.printDistanceMarker(racingCar.getName(), racingCar.getDistance());
        }
    }

    /**
     * 우승자를 보여준다.
     */
    private void displayWinners() {
        OutputView.printWinnersMessage(carList.getWinners());
    }
}
