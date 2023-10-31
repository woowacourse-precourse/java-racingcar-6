package racingcar.controller;

import racingcar.Dto.GameInputDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class InputController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public GameInputDto gameStart(){
        outputView.printCarName();
        List<String> carNames = inputView.getName();

        outputView.printHowManyRound();
        int numberRound =inputView.getNumberOfRound();

        outputView.printGameStart();

        GameInputDto gameInputDto = new GameInputDto(carNames, numberRound);
        return gameInputDto;
    }
}
