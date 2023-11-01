package racingcar.util;

public class InputUtil {

    public static String[] splitCarName(String carName) {
        return validateCarName(carName);
    }

    public static int getRaceLap(String raceLap) {
        return validateLap(raceLap);
    }

    private static int validateLap(String raceLap) {
        if (!isValidLap(raceLap)) {
            throw new IllegalArgumentException(Constants.LAP_NOT_POSITIVE_INTEGER_EXCEPTION);
        }
        return Integer.parseInt(raceLap);
    }

    private static String[] validateCarName(String carName) {
        String[] carNameStrings = carName.split(",");

        isMinimum2Car(carNameStrings);
        areCarNameLongerThan5(carNameStrings);

        return carNameStrings;
    }

    private static void areCarNameLongerThan5(String[] carNameStrings) {
        for (String carNameStr : carNameStrings) {
            if (carNameStr.length() > Constants.MINIMUM_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(Constants.CAR_NAME_LONGER_THAN_5_EXCEPTION);
            }
        }
    }

    private static void isMinimum2Car(String[] carNameStrings) {
        if (carNameStrings.length < Constants.MINIMUM_CAR_INPUT) {
            throw new IllegalArgumentException(Constants.MINIMUM_CAR_COUNT_EXCEPTION);
        }
    }

    private static boolean isValidLap(String raceLap) {
        return isLapInteger(raceLap) && isPositiveInteger(raceLap);
    }

    private static boolean isPositiveInteger(String raceLap) {
        return Integer.parseInt(raceLap) > 0;
    }

    private static boolean isLapInteger(String raceLap) {
        try {
            Integer.parseInt(raceLap);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
