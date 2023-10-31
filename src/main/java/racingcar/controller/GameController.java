package racingcar.controller;

import racingcar.Dto.GameInputDto;
import racingcar.model.CarList;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    InputController inputController = new InputController();
    OutputView outputView = new OutputView();

    public void start() {
        GameInputDto gameInputDto = inputController.gameStart();
        List<String> carNames = gameInputDto.getCarNames();
        int numberRound = gameInputDto.getNumberRound();

        CarList carList = new CarList(carNames, numberRound);
        carList.initialPosition();

        for (int i = 0; i < numberRound; i++) {
            int carPosition = carList.setCarPosition(i);
            outputView.printRoundResult(carNames.get(i), carPosition);
        }

    }
}
