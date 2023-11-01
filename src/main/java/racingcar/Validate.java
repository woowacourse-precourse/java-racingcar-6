package racingcar;

public class Validate {

    public static boolean checkLetterNum(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
