package racingcar.util;

public class validation {
    private static final int MAX_NAME_LENGTH = 5;
    public static void checkCarName(String carName) throws IllegalArgumentException {
        if(carName.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    public static void checkTryNumber(String tryNum) throws IllegalArgumentException {
        try {
            Integer.parseInt(tryNum);
        }catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }
}
