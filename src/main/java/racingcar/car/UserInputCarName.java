package racingcar.car;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputCarName {
    private static String inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static String[] splitByComma(String inputCarName) {
        return inputCarName.split(",");
    }

    private static CarInfo createCar(String carName) {
        return new CarInfo(carName.trim());
    }

    private static List<CarInfo> addCarList(String[] cars){
        List<CarInfo> carList = new ArrayList<>();
        for (String carName : cars) {
            carList.add(createCar(carName.trim()));
        }
        return carList;
    }

    private static void validator(List<CarInfo> carList){
        ValidateCar.validator(carList);
    }

    public static void run() {
        String inputCarName = inputName();
        String[] cars = splitByComma(inputCarName);
        List<CarInfo> carList = addCarList(cars);
        validator(carList);
    }
}
