package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.service.RacingService;
import racingcar.service.ValidationService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    ValidationService validationService = new ValidationService();
    RacingService racingService = new RacingService();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    private final CarList racingCars = new CarList();

    public void startRacing() {
        // 1. 차량 이름 입력
        List<String> carNames = getCarNameList();

        // 2. 시도 횟수 입력
        int trialCount = getTrialCount();
        System.out.println();

        // 3. 차량 객체 생성
        makeCar(carNames);

        // 4. 시도 횟수만큼 레이싱 진행
        System.out.println("실행 결과");
        tryRacing(trialCount);

        // 5. 우승 차량 확인
        List<Car> winningCarList;
        winningCarList = racingCars.calculateWinningCars();

        // 6. 우승 차량 출력
        StringBuilder winners = new StringBuilder();
        winners = winners.append(winningCarList.get(0).provideCarStatus().get("name"));
        if (winningCarList.size() > 1) {
            for (int i = 1; i < winningCarList.size(); i ++) {
                winners.append(", ");
                winners.append((String) winningCarList.get(i).provideCarStatus().get("name"));
            }
        }
        outputView.printWinnerCars(winners.toString());
    }

    private void tryRacing(int trialCount) {
        for (int i = 0; i < trialCount; i++) {
            racingService.racingByTheNumberOfTrialCount(racingCars);
            printRacingResults();
            System.out.println();
        }
    }

    private void printRacingResults() {
        for (Car racingCar : racingCars.provideRacingCars()) {
            String carName = (String) racingCar.provideCarStatus().get("name");
            int carPosition = (int) racingCar.provideCarStatus().get("position");
            outputView.printRacingResult(carName, carPosition);
        }
    }

    private void makeCar(List<String> carNames) {
        for (String carName : carNames) {
            racingCars.addCar(new Car(carName));
        }
    }

    private List<String> getCarNameList() {
        String carNames = inputView.insertCarName();
        return validationService.checkCarNames(carNames);
    }

    private int getTrialCount() {
        String inputTrialCount = inputView.insertTrialCount();
        return validationService.checkTrialCount(inputTrialCount);
    }
}
