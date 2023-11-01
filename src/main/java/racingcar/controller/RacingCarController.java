package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();

    public void doRace() {
        outputView.printEnterCarNames();
        String[] carNames = inputView.askCarNames();
        outputView.printEnterMoveCount();
        int moveCount = inputView.askMoveCount();
        System.out.print("\n");
        outputView.printExecResult();
        List<RacingCar> racingCars = generateCars(carNames);

        // race start
        do {
            racingCars.forEach(RacingCar::moveForwardOrNot);
            outputView.printRacingResultEachCount(racingCars);
            moveCount--;
        } while (moveCount > 0);
        // race end

        List<String> winnerNames = selectWinner(racingCars);
    }

    private List<RacingCar> generateCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private List<String> selectWinner(List<RacingCar> racingCars) {
        int maxCurrentPosition = maxCurrentPositionAmongCars(racingCars);
        return racingCars.stream()
                .filter(car -> car.getCurrentPosition() == maxCurrentPosition)
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }

    private int maxCurrentPositionAmongCars(List<RacingCar> racingCars) {
        return racingCars.stream()
                .mapToInt(RacingCar::getCurrentPosition)
                .max()
                .orElse(0);
    }
}
