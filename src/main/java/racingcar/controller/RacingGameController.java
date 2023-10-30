package racingcar.controller;


import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingCarService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingCarService();
    }

    public void playRacingGame() {
        String input = InputView.inputCarsName();
        List<String> cars = Arrays.asList(input.split(","));
        List<Car> carList = racingGameService.participateCar(cars);

        int moveCount = InputView.inputMovesCount();
        System.out.println("실행 결과");
        while (moveCount-- > 0) {
            RacingCarService.moveCar();
            System.out.println();
        }
        OutputView.printFinalWinner(racingGameService.findWinners());
    }
}
