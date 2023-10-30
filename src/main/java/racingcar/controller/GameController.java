package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.PlayCount;
import racingcar.model.randomnumber.RandomNumber;
import racingcar.view.input.InputView;
import racingcar.view.output.Outputview;

public class GameController {

    private final InputView inputView;
    private final Outputview outputView;
    private final RandomNumber randomNumber;

    public GameController(final InputView inputView, final Outputview outputView, final RandomNumber randomNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumber = randomNumber;
    }

    public void play() {
        outputView.askCarNames();

        Cars playCars = Cars.from(inputView.readLine());
        PlayCount playCount = PlayCount.createDefault(inputView.readLine());

        while (!playCount.isGameEnd()) {
            playCars.race(randomNumber);
            playCount.endOneRound();
        }
    }
}
