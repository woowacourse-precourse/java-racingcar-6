package racingcar;

public class InputValidator {

    public boolean checkStringLength(String name) {
        if (name.length() > 5) {
            return false;
        }
        return true;
    }
}
