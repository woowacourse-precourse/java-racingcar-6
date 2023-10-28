package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.exception.Exception;

public class GameService {

    public static void run() {
        List<String> carName = checkCarName(InteractService.getCarName());

        List<Car> carList = carName.stream().map(Car::new).collect(Collectors.toList());

        int tryNum = InteractService.getTryNum();

        InteractService.printResult(carList, tryNum);
    }

    private static List<String> checkCarName(String carNames) {
        List<String> carNameList = new ArrayList<>();

        for (String s : carNames.split(",")) {
            if (Exception.checkNameValidation(carNameList, s)) {
                throw new IllegalArgumentException();
            }
            carNameList.add(s);
        }
        return carNameList;
    }


}
