package racingcar;

public class DealWithExceptionCase {
    public static void IsNameAccurate(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException();
    }
}
