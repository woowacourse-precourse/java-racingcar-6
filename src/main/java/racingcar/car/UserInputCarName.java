package racingcar.car;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constant;

import java.util.ArrayList;
import java.util.List;

public class UserInputCarName {
    public static List<CarInfo> getCarList() {
        String inputCarName = inputName();
        return processInput(inputCarName);
    }

    private static String inputName() {
        System.out.println(Constant.NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static List<CarInfo> processInput(String input) {
        String[] cars = splitByComma(input);
        List<CarInfo> carList = addCarList(cars);
        validator(carList);

        return carList;
    }

    private static String[] splitByComma(String inputCarName) {
        return inputCarName.split(",");
    }

    private static List<CarInfo> addCarList(String[] cars){
        List<CarInfo> carList = new ArrayList<>();

        for (String carName : cars) {
            carList.add(createCar(carName.trim()));
        }

        return carList;
    }

    private static CarInfo createCar(String carName) {
        return new CarInfo(carName.trim());
    }

    private static void validator(List<CarInfo> carList){
        ValidateCar.validator(carList);
    }
}
