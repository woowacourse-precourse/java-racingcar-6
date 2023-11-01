package racingcar.util;

public class InputUtil {

    public static String[] splitCarName(String carName) {
        return validateCarName(carName);
    }

    private static String[] validateCarName(String carName) {
        String[] carNameStrings = carName.split(",");

        for (String carNameStr : carNameStrings) {
            if (carNameStr.length() > 5 || carNameStr.isEmpty()) {
                throw new IllegalArgumentException(Constants.CAR_NAME_LONGER_THAN_5_EXCEPTION);
            }
        }

        return carNameStrings;
    }

    public static int getRaceLap(String raceLap) {
        return validateRaceLap(raceLap);
    }

    private static int validateRaceLap(String raceLap) {
        int lap;

        try {
            lap = Integer.parseInt(raceLap);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.LAP_NO_INTEGER_INPUT_EXCEPTION);
        }

        if (lap <= 0) {
            throw new IllegalArgumentException(Constants.LAP_NOT_POSITIVE_INTEGER_EXCEPTION);
        }

        return lap;
    }
}
