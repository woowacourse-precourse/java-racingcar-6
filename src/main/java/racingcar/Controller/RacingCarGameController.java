package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;
import racingcar.Util.InputValidator;
import racingcar.View.InputView;

public class RacingCarGameController {

    public void initRacingCarGame(){
        List<String> carNameList = InputView.inputRacingCarName();
        InputValidator.checkCarNameLength(carNameList);
        String racingRoundTimes = InputView.inputRacingRoundTimes();
        InputValidator.checkIsNumber(racingRoundTimes);

        createRacingCar(carNameList);
    }

    public void createRacingCar(List<String> carNameList){
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }
}
