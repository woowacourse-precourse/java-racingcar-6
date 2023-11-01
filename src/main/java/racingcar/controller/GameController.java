package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Game;
import racingcar.model.RacingCar;
import racingcar.model.TrialCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private static final String DELIMITER_WINNERS = ", ";
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private final List<RacingCar> racingCars;
    private final Game game;


    public GameController() {
        racingCars = convertToRacingCars(INPUT_VIEW.inputCarNames());
        game = Game.createByRacingCars(racingCars);
    }

    public void start() {
        TrialCount trialCount = new TrialCount(INPUT_VIEW.inputTrialCount());
        while (trialCount.isNotZero()) {
            OUTPUT_VIEW.printGameStatus(playGame());
            trialCount.consumed();
        }
        OUTPUT_VIEW.printWinner(convertToString(game.findWinners()));
    }

    private Game playGame() {
        for (RacingCar racingCar : racingCars) {
            game.updateStatus(racingCar, () -> Randoms.pickNumberInRange(0, 9));
        }
        return game;
    }

    private List<RacingCar> convertToRacingCars(List<String> names) {
        return names.stream()
                .map(RacingCar::new)
                .toList();
    }

    private String convertToString(List<RacingCar> racingCars) {
        return String.join(DELIMITER_WINNERS, racingCars.stream()
                .map(racingCar -> racingCar.toString())
                .toList());
    }
}
