package racingcar.domain;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarData {

    public static List<RacingCar> carData() {

        List<String> carNameList = InputView.carName();

        List<RacingCar> carData = new ArrayList<>();

        for (int i = 0; i < carNameList.size(); i++) {
            RacingCar racingCar = new RacingCar();
            racingCar.car(i, carNameList.get(i));
            carData.add(racingCar);
        }

        return carData;
    }
}
