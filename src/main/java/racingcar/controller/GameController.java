package racingcar.controller;

import racingcar.Dto.GameInputDto;
import racingcar.model.CarList;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    InputController inputController = new InputController();
    OutputView outputView = new OutputView();
    CarList carList = new CarList();

    public void start() {
        GameInputDto gameInputDto = inputController.gameStart();

        List<String> carNames = gameInputDto.getCarNames();
        int numberRound = gameInputDto.getNumberRound();

        List<Integer> carPositions = carList.initialPosition(carNames.size());

        for (int i = 0; i < numberRound; i++) {
            carPositions = carList.setCarPositions(carPositions);
            outputView.printRoundResults(carNames, carPositions);
        }

        outputView.printWinner(carList.decideWinner(carPositions, carNames));
    }
}
