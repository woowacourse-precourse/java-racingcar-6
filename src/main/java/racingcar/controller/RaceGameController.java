package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class RaceGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        RacingCars racingCars = initializeGame();

        inputView.printLoopSetMessage();
        int loop = Integer.parseInt(Console.readLine());

        outputView.printFirstResultMessage();
        playGameMultipleTimes(racingCars, loop);

        Referee referee = new Referee();
        referee.findWinnerDistance(racingCars);

        List<String> winnerNames = referee.winnerNameList(racingCars);
//        outputView.printWinnerResultMessage(winnerNames);
//        여기 리펙토링 시급
    }

    private RacingCars initializeGame() {
        inputView.printStartMessage();
        String names = Console.readLine();
        List<String> carNames = splinter(names);
        return new RacingCars(carNames);
    }

    private void playGameMultipleTimes(RacingCars racingCars, int loop) {
        for (int i = 0; i < loop; i++) {
            playingGame(racingCars);
        }
    }

    private void playingGame(RacingCars racingCars) {
        for (Car car : racingCars.getAllCars()) {
            car.moveIfRandomSuccess();
            outputView.printRaceStatusMessage(car);
        }
        outputView.printSpaceMessage();
    }

    private List<String> splinter(String name) {
        return Arrays.stream(name.split(","))
                .collect(Collectors.toList());
    }
}