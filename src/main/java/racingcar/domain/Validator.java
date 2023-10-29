package racingcar.domain;

public class Validator {
    private Validator(){

    }

    public static boolean isValidCarName(String name) {
        return !(name.length() >= 1 && name.length() <= 5);
    }

    public static boolean isEmpty(String carNames){
        return carNames.trim().isEmpty();
    }
}
