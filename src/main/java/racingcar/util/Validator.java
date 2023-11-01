package racingcar.util;

import java.util.HashSet;
import java.util.Set;
import racingcar.model.Car;
import racingcar.model.Cars;

public class Validator {
    //carDtoList로 변환하는 로직
    public static void validateCars(Cars cars) {
        checkSizeOne(cars);
        checkNamesLengthOverFive(cars);
        checkNameDuplicated(cars);
    }

    public static int validateNumber(String roundNumberString) {
        checkNumberFormat(roundNumberString);
        checkNumberZero(roundNumberString);
        return Integer.parseInt(roundNumberString);
    }

    private static void checkNumberFormat(String string) {
        try {
            int round = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumberZero(String string) {
        int number = Integer.parseInt(string);
        if (Integer.parseInt(string)== 0) {
            throw new IllegalArgumentException();
        }
    }


    private static void checkSizeOne(Cars cars) {
        if (cars.size() == 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNamesLengthOverFive(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car carInList = cars.get(i);
            checkNameLengthOverFive(carInList);
        }
    }

    private static void checkNameLengthOverFive(Car car) {
        String carNameInList = car.getCarName();

        if (carNameInList.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNameDuplicated(Cars cars) {
        Set<String> carNameSet = new HashSet<>();
        for (int i = 0; i < cars.size(); i++) {
            Car carInList = cars.get(i);
            String carNameInList = carInList.getCarName();
            carNameSet.add(carNameInList);
        }

        if (carNameSet.size() != cars.size()) {
            throw new IllegalArgumentException();
        }
    }


}
