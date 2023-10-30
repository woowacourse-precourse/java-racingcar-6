package racingcar;

public final class Validator {

    public static void limitStringLength(String input, int maxLength) {
        if (input.length() > maxLength) {
            String message = "The length of input should be less or equal than " + maxLength;
            throw new IllegalArgumentException(message);
        }
    }


    private Validator() {
    }

}
