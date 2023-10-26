package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public final class Util {

    private Util(){

    }
    public static boolean hasDuplicates(List<String> list) {
        Set<String> uniqueItems = new HashSet<>(list);
        return uniqueItems.size() != list.size();
    }

    public static ArrayList<String> toArray(String cars){
        return new ArrayList<>(Arrays.asList(cars.split(",")));
    }

    public static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static List<String> splitString(String input, String delimiter) {
        return new ArrayList<>(List.of(input.split(delimiter)));
    }
    public static boolean matchesPattern(String input, Pattern pattern) {
        return pattern.matcher(input).matches();
    }
    private void validateInputIsNotEmpty(String input) {
        if (Util.isNullOrEmpty(input)) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
    }
//    private void validateInputPattern(String input) {
//        if (!Util.matchesPattern(input, CAR_NAME_PATTERN)) {
//            throw new IllegalArgumentException("입력에 문자, 숫자, 쉼표 외의 문자가 포함되어 있습니다.");
//        }
//    }
}
