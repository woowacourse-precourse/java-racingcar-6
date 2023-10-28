package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class GameService {

    public static void run() {
        List<Car> carList = new ArrayList<>();
        checkCarNameAndMakeCar(InteractService.getCarName(), carList);

        int tryNum = InteractService.getTryNum();
        checkPositive(tryNum);

        InteractService.printResult(carList, tryNum);
    }

    private static void checkPositive(int tryNum) {
        if (tryNum <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkCarNameAndMakeCar(String carNames, List<Car> carList) {
        List<String> carNameList = new ArrayList<>();

        for (String s : carNames.split(",")) {
            if (checkNameValidation(carNameList, s)) {
                throw new IllegalArgumentException();
            }
            carNameList.add(s);
            carList.add(new Car(s));
        }
    }

    private static boolean checkNameValidation(List<String> carNameList, String s) {
        return s.contains(" ") || s.length() > 5 || carNameList.contains(s);
    }
}
