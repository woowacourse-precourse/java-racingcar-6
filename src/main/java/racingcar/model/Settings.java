package racingcar.model;

public class Settings {
    public static final int NAME_MAX_LENGTH = 5;
    public static int CAR_AMOUNT;
    public static int ROUND_MAX;

    public static void setCarAmount(int amount) {
        CAR_AMOUNT = amount;
    }

    public static void setRound(int round) {
        ROUND_MAX = round;
    }

}
