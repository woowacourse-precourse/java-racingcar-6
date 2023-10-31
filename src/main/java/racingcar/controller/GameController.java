package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.GameScore;
import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private final List<RacingCar> racingCars;
    private final GameScore gameScore;


    public GameController() {
        racingCars = convertToRacingCars(INPUT_VIEW.inputCarNames());
        gameScore = GameScore.createByRacingCars(racingCars);
    }

    public void start() {
        int gameCount = INPUT_VIEW.inputGameCount();
        while (gameCount-- != 0) {
            OUTPUT_VIEW.printGameScore(playOnce());
        }
        OUTPUT_VIEW.printWinner(convertToString(gameScore.getWinner()));
    }

    private GameScore playOnce() {
        for (RacingCar racingCar : racingCars) {
            gameScore.update(racingCar, () -> Randoms.pickNumberInRange(0, 9));
        }
        return gameScore;
    }

    private List<RacingCar> convertToRacingCars(List<String> names) {
        return names.stream()
                .map(RacingCar::new)
                .toList();
    }

    private String convertToString(List<RacingCar> racingCars) {
        return String.join(", ", racingCars.stream()
                .map(racingCar -> racingCar.toString())
                .toList());
    }
}
