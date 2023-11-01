package racingcar;

import java.util.List;

public class UserInputReceiver {

    public static List<String> ReceiveCarNames(String rawInput) {

        List<String> split = List.of(rawInput.split(","));

        elementLengthValidate(split);

        return split;
    }

    public static int receiveTryTimes(String rawInput) {

        int inputNumber = tryParseInt(rawInput);

        numberRangeValidate(inputNumber);

        return inputNumber;
    }

    private static void numberRangeValidate(int inputNumber) {
        if (inputNumber <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static int tryParseInt(String rawInput) {
        int parsedInt;
        try {
            parsedInt = Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return parsedInt;
    }

    private static void elementLengthValidate(List<String> split) {
        split.forEach(e -> {
            if (e.length() >= 5) throw new IllegalArgumentException();
        });
    }

}
