package racingcar.utility;

public class Utility {
    public String[] splitStringToArray (String carNames) {
        String[] carNameArray = carNames.split(",");

        return carNameArray;
    }

    public int makeStringToInt (String stringOfTimes) {
        int intOfTimes = Integer.parseInt(stringOfTimes);

        return intOfTimes;
    }
}
