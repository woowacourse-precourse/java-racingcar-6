package racingcar.controller;

import java.util.List;
import racingcar.domain.Game;
import racingcar.util.RandomNumberGenerator;
import racingcar.dto.RaceProgressResponse;
import racingcar.dto.WinnerResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RandomNumberGenerator generator = new RandomNumberGenerator();

    public void race(){
        Game game = setUp();
        outputView.printRaceProgressMessage();
        for (int i = 0; i < game.getRaceCount(); i++) {
            List<Integer> randomNumbers = generator.generateRandomNumbers(game.getCars().size());
            RaceProgressResponse response = game.move(randomNumbers);
            outputView.printRaceResult(response);
        }
        WinnerResponse winnerResponse = game.selectWinner();
        outputView.printWinner(winnerResponse);
    }

    private Game setUp() {
        String cars = inputView.getCars();
        String raceCount = inputView.getRaceCount();
        Game game = new Game(cars, raceCount);
        return game;
    }
}