package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.service.ValidationService;
import racingcar.view.InputView;

public class RacingController {

    ValidationService validationService = new ValidationService();
    InputView inputView = new InputView();

    private final CarList racingCars = new CarList();

    public void startRacing() {
        // 1. 차량 이름 입력
        List<String> carNames = getCarNameList();

        // 2. 시도 횟수 입력
        int trialCount = getTrialCount();

        // 3. 차량 객체 생성
        makeCar(carNames);
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
