package racingcar.Exception;

public class ExceptionHandler {

    private static String[] inputs;
    private static final int MAXNAMESIZE = 5;

    public static String[] checkNameInputException(String input) {

        inputs = input.split(",");

        for (int i = 0; i < inputs.length; i++) {

            checkNameSize(inputs[i]);
            checkNameChar(inputs[i]);
        }

        return inputs;
    }

    private static void checkNameSize(String input) {

        if (input.length() > MAXNAMESIZE) {

            throw new IllegalArgumentException();
        }
    }

    private static void checkNameChar(String input) {

        for (char c : input.toCharArray()) {

            if (!Character.isLetter(c)) {

                throw new IllegalArgumentException();
            }
        }
    }

    public static int checkRepeatCountInputException(String input) {

        try {

            return Integer.parseInt(input);
        } catch (Exception e) {

            throw new IllegalArgumentException();
        }
    }
}
