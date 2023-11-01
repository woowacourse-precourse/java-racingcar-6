package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.view.input.error.InputError;
import racingcar.view.input.error.InputIllegalArgumentException;

public final class Input {

    public static final Pattern REMOVE_REGEX_PATTERN = Pattern.compile("\\s");
    public static final String DIVIDING_STANDARD = ",";
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final int MINIMUM_NAME_LENGTH = 1;

    public static List<String> inputNames() {
        String name = Console.readLine();

        return devideToList(name);
    }

    public static int inputTrialAmount() {
        String trialAmount = Console.readLine();
        validateNotBlank(trialAmount);

        try {
            return Integer.parseInt(trialAmount);

        } catch (InputIllegalArgumentException e) {
            throw new InputIllegalArgumentException(InputError.MUST_BE_NUMBER);
        }
    }

    private static List<String> devideToList(String value) {
        String removedSpaceValue = removeSpace(value);
        List<String> dividedName = Arrays.stream(removedSpaceValue.split(DIVIDING_STANDARD)).toList();

        validateNameLength(dividedName);

        return dividedName;
    }

    private static String removeSpace(String value) {

        return REMOVE_REGEX_PATTERN.matcher(value).replaceAll("");
    }

    private static void validateNameLength(List<String> names) {
        long countNames = names.stream()
                .dropWhile(name -> name.length() >= MINIMUM_NAME_LENGTH && name.length() <= MAXIMUM_NAME_LENGTH)
                .count();

        if (countNames > 0) {
            throw new InputIllegalArgumentException(InputError.EXCEEDED_MAXIMUM_ERROR, MAXIMUM_NAME_LENGTH,
                    MINIMUM_NAME_LENGTH);
        }
    }

    private static void validateNotBlank(String trialAmount) {
        if (trialAmount.isBlank()) {
            throw new InputIllegalArgumentException(InputError.TRIAL_MUST_NOT_BLANK);
        }
    }
}
