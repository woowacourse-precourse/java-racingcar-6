package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.util.Validator.Validator;

public class FormatUtil {

    private static final String DIVIDING_STANDARD = ",";
    private static final String MERGING_STANDARD = ", ";
    private static final String DISTANT_MARK = "-";
    private static final Pattern REMOVE_REGEX_PATTERN = Pattern.compile("\\s");

    public static List<String> devideToList(String value){
        String removedSpaceValue = removeSpace(value);
        List<String> dividedName =  Arrays.stream(removedSpaceValue.split(DIVIDING_STANDARD)).toList();
        Validator.validateNameLength(dividedName);
        return dividedName;
    }

    public static String removeSpace(String value){
        return REMOVE_REGEX_PATTERN.matcher(value).replaceAll("");
    }

    public static String joinListValues(List<String> names){
        return String.join(MERGING_STANDARD, names);
    }

    public static String joinCarsDistances(int distance){
        return String.valueOf(DISTANT_MARK).repeat(distance);
    }
}
