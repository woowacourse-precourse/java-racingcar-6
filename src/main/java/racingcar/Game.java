package racingcar;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LinkedHashMap<String, String> carList;
    int totalCount;

    public void run() {
        outputView.printMessage(Message.INPUT_CAR_NAME.getMessage() + "\n");
        carList = inputView.getCarNameInput();

        outputView.printMessage(Message.INPUT_REPEAT_NUMBER.getMessage() + "\n");
        totalCount = inputView.getGameCountInput();

        outputView.printMessage(Message.GAME_RESULT.getMessage() + "\n");

        for (int i = 0; i < totalCount; i++) {
            doOneRound();
        }

        announceWinner();
    }

    private void doOneRound() {
        for (Entry<String, String> carResult : carList.entrySet()) {
            String carName = carResult.getKey();
            Car car = new Car();

            if (car.checkForward()) {
                carList.put(carName, carList.get(carName) + "-");
            }

            outputView.printCarResult(carName, carList.get(carName));
        }

        System.out.println();
    }

    private void announceWinner() {
        int maxLen = checkMaxLen(carList);

        List<String> winnerList = getWinnerList(maxLen, carList);

        outputView.printWinnerList(winnerList);
    }

    private int checkMaxLen(LinkedHashMap<String, String> carList) {
        int maxLen = 0;

        for (Entry<String, String> carResult : carList.entrySet()) {
            int len = carResult.getValue().length();

            maxLen = max(maxLen, len);
        }

        return maxLen;
    }

    private List<String> getWinnerList(int len, LinkedHashMap<String, String> carList) {
        List<String> winnerList = new ArrayList<>();

        for (Entry<String, String> carResult : carList.entrySet()) {
            if (isWinner(len, carResult)) {
                winnerList.add(carResult.getKey());
            }
        }

        return winnerList;
    }

    private boolean isWinner(int len, Entry<String, String> carResult) {
        return carResult.getValue().length() == len;
    }
}
