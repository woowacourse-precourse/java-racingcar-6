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
        List<String> cars = inputView.getCars();
        int raceCount = inputView.getRaceCount();
        Game game = new Game(cars);
        outputView.printRaceProgressMessage();

        for (int i = 0; i < raceCount; i++) {
            List<Integer> randomNumbers = generator.generateRandomNumbers(cars.size());
            RaceProgressResponse response = game.move(randomNumbers);
            outputView.printRaceResult(response);
        }
        WinnerResponse winnerResponse = game.selectWinner();
        outputView.printWinner(winnerResponse);
    }
}