package racingcar.controller;

import racingcar.domain.CarRacingGame;
import racingcar.model.Car;
import racingcar.repository.CarRepository;
import racingcar.utils.StringUtils;
import racingcar.utils.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

// 필드 인스턴스 변수 ~2 (규영님 말씀)
// 스트링 joiner (스트링 빌드 대신) - 알아보기!!
// 의존관계 줄이기 -> domain, controller에서 전부 carRacingGame 의존중
public class RacingController {
    private final InputView inputview;
    private final OutputView outputView;
    private final CarRacingGame carRacingGame;
    private final CarRepository carRepository;

    public RacingController() {
        inputview = new InputView();
        outputView = new OutputView();
        carRacingGame = new CarRacingGame();
        carRepository = new CarRepository();
    }

    public void playCarRacingGame() {
        String inputCars = inputview.readInputCars();
        int trialNumber = inputview.readTrialNumber();

        preprocessInput(inputCars);
        playEachRacing(trialNumber);
        StringBuilder winners = formatWinnersList();
        outputView.printWinners(winners.toString());
    }

    private StringBuilder formatWinnersList() {
        List<String> winnersList = carRacingGame.getWinningCarNames();
        return StringUtils.joinWithCommas(winnersList);
    }

    private void preprocessInput(String inputCars) {
        String[] carArray = StringUtils.splitByComma(inputCars);
        InputValidator.checkValidStringLength(carArray); // car클래스에서 검증하거나, carName 중 name 객체 관심사 분리해서 거기 넣으면 더 good!!!!
        // name 생성자에서 validation

        carRacingGame.saveCars(carArray);
    }

    private void playEachRacing(int trialNumber) {
        for (int i = 0; i < trialNumber; i++) {
            List<Car> cars = carRepository.findAll();
            carRacingGame.eachCarRacing();
            outputView.printEachRacingResult(cars, cars.size());
        }
    }
}
