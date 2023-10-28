package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.Referee;
import racingcar.domain.TypeCasting;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    public void start() {
        OutputView.askCarName();
        RacingCars racingcars = TypeCasting.stringToRacingCars(InputView.askCarName());
        OutputView.askPlayTime();
        final int playTime = TypeCasting.stringToInteger(InputView.askPlayTime());
        OutputView.showResultMessage();
        for (int i = 0; i < playTime; i++) {
            Referee.simulate(racingcars);
            OutputView.showCurrentDistance(racingcars);
        }
        RacingCars winners = Referee.calculateWinner(racingcars);
        OutputView.showFinalWinner(winners);

    }
}