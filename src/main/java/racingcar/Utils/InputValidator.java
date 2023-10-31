package racingcar.Utils;

import java.util.List;


public class InputValidator {
    public static List<String> checkCarNameList(String carNameList) {
        List<String> carList = List.of(carNameList.split(","));
        for(var car : carList)
        {
            if (!isValidNameLength(car.length()) || checkSpacesInName(car))
                throw new IllegalArgumentException();
        }
        return carList;
    }

    public static int checkNumberOfAttempts(String numberOfAttempts) {
        String regExp = "^[0-9]+$";
        if (!numberOfAttempts.matches(regExp)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(numberOfAttempts);
    }

    private static boolean isValidNameLength(int carNameLength) {
        return carNameLength <= 5 && carNameLength > 0;
    }

    private static boolean checkSpacesInName(String carName)
    {
        return carName.isEmpty() || carName.contains(" ");
    }
}
