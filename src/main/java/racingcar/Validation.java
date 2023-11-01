package racingcar;

public class Validation {

    public static String CarNameCheck(String name) {

        if (name.length() > 5)
            throw new IllegalArgumentException();

        return name;
    }

    public static int attemptValueCheck(String attemptValue) throws IllegalArgumentException{

        int attemptValueCheck = Integer.parseInt(attemptValue);

        if (attemptValueCheck < 1)
            throw new IllegalArgumentException();

        return attemptValueCheck;
    }
}
