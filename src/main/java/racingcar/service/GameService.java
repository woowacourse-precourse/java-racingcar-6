package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.exception.Exception;

public class GameService {

    public static void run() {
        List<Car> carList = new ArrayList<>();
        checkCarNameAndMakeCar(InteractService.getCarName(), carList);

        int tryNum = InteractService.getTryNum();
        Exception.checkPositive(tryNum);

        InteractService.printResult(carList, tryNum);
    }

    private static void checkCarNameAndMakeCar(String carNames, List<Car> carList) {
        List<String> carNameList = new ArrayList<>();

        for (String s : carNames.split(",")) {
            if (Exception.checkNameValidation(carNameList, s)) {
                throw new IllegalArgumentException();
            }
            carNameList.add(s);
            carList.add(new Car(s));
        }
    }


}
