package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.util.Validator.Validator;
import racingcar.view.input.error.InputError;
import racingcar.view.input.error.InputException;

public final class Input {

    public static final Pattern REMOVE_REGEX_PATTERN = Pattern.compile("\\s");
    public static final String DIVIDING_STANDARD = ",";

    public static List<String> bringNames() {
        String name = Console.readLine();
        return devideToList(name);
    }

    public static int bringTrialAmount() {
        String trialAmount = Console.readLine();
        try {
            return Integer.parseInt(trialAmount);
        } catch (InputException e) {
            throw new InputException(InputError.MUST_BE_NUMBER);
        }
    }

    private static List<String> devideToList(String value) {
        String removedSpaceValue = removeSpace(value);
        List<String> dividedName = Arrays.stream(removedSpaceValue.split(DIVIDING_STANDARD)).toList();
        Validator.validateNameLength(dividedName);
        return dividedName;
    }

    private static String removeSpace(String value) {
        return REMOVE_REGEX_PATTERN.matcher(value).replaceAll("");
    }
}
