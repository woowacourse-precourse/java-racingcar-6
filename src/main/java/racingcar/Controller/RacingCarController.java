package racingcar.Controller;
import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Race;
import racingcar.Domain.RacingCars;
import racingcar.Service.RaceService;
import racingcar.Service.WinnerService;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.Service.CarService;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;
    private final RaceService raceService;
    private final WinnerService winnerService;

    public RacingCarController() {
        inputView = new InputView();
        outputView = new OutputView();
        carService = new CarService();
        raceService = new RaceService();
        winnerService = new WinnerService();
    }
    public void carRacing() {
        // 자동차 이름 입력
        String carNames = inputView.inputCar();
        carService.inputCarNames(carNames);

        // 경주 횟수 입력
        int raceCount = inputView.inputRaceTime();
        raceService.inputRaceCount(raceCount);

        // 경주 시작
        carService.runRacing();
        outputView.printResult(carService.carList());

        // 우승자 결정
        outputView.printWinner(winnerService.getWinners());
    }
}
