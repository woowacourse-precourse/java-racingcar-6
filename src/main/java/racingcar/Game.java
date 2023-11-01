package racingcar;

import java.util.LinkedHashMap;
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
}
