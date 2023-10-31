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

        // 3. 차량 객체 생성
        makeCar(carNames);

        // 4. 시도 횟수만큼 레이싱 진행
        tryRacing(trialCount);
    }

    private void tryRacing(int trialCount) {
        for (int i = 0; i < trialCount; i++) {
            racingService.racingByTheNumberOfTrialCount(racingCars);
            printRacingResults();
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
