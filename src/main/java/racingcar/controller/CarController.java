package racingcar.controller;

import static racingcar.exception.ExceptionCheck.nameLengthValidation;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.exception.ExceptionCheck;
import racingcar.model.CarModel;
import racingcar.view.OutputView;

public class CarController {

    private List<CarModel> carModelList = new ArrayList<>();

    public CarController(List<String> carList) {
        for (String s : carList) {
            ExceptionCheck.nameLengthValidation(s);
            this.carModelList.add(new CarModel(s));
        }
    }

    public void carForward() {
        for ( CarModel carModel : carModelList) {
            if (forwardCheck()) {
                carModel.increaseLocation();
            }
            OutputView.printRacing(carModel.carLocationState());
        }
        System.out.println("");
    }

    private boolean forwardCheck() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public List<CarModel> winnerCheck(int maxLocation) {
        List<CarModel> winnerCars = new ArrayList<>();
        List<CarModel> Cars;

        for (int i = 0 ;i <= maxLocation; i++) {
            Cars = maxLocationCheck(i);
            if (Cars.size() > 0) {
                winnerCars = Cars;
            }
        }
        return winnerCars;
    }

    private List<CarModel> maxLocationCheck(int maxLocation) {
        List<CarModel> winnerCars = new ArrayList<>();

        for ( CarModel carModel : carModelList) {
            if (carModel.compareMaxLocation(maxLocation)) {
                winnerCars.add(carModel);
            }
        }
        return winnerCars;
    }
}
