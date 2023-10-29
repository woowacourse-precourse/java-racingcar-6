package racingcar.model;

public class Settings {
    public static int NAME_MAX_LENGTH = 5;
    public static int CAR_AMOUNT;
    public static int ATTEMPT_MAX;

    public static void setCarAmount(int amount) {
        CAR_AMOUNT = amount;
    }

    public static void setAttempts(int attempts) {
        ATTEMPT_MAX = attempts;
    }

}
