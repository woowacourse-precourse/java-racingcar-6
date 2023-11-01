package racingcar.service;

import static racingcar.constant.Constant.SPLIT_REGEX;

import java.util.List;
import racingcar.dto.FinalResultDto;
import racingcar.dto.SetResultDto;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.validator.InputValidator;

public class CarRacingGameService {
    public Car getCar(String carNameInput) {
        List<String> carNameInputList = List.of(carNameInput.split(SPLIT_REGEX));

        InputValidator.validateCarNameInput(carNameInputList);

        return new Car(carNameInputList);
    }

    public Game getGame(Car cars, String gameSetInput) {
        InputValidator.validateGameSetInput(gameSetInput);

        return new Game(cars, gameSetInput);
    }

    public boolean isContinue(Game game) {
        return game.isContinue();
    }

    public SetResultDto playSet(Game game) {
        game.playSet();

        return new SetResultDto(game.getCars());
    }

    public FinalResultDto getFinalResult(Game game) {
        return new FinalResultDto(game.getWinnerList());
    }
}
