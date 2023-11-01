package racingcar.service;

public class Input {

    public static String[] splitCarName(String notSplitCar) {

        String[] carName = notSplitCar.split(",");

        return carName;
    }
    public static int assignChallengeNumber(String number) {
        int intNumber = Integer.parseInt(number);

        return intNumber;
    }
}
