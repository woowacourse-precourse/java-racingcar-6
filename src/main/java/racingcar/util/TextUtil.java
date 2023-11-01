package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Class : 문자열 유틸 클래스
 */
public class TextUtil {

    public static List<String> splitAndTrim(String target, String splitRegex) {
        return Arrays.stream(target.split(splitRegex))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static boolean isOverLength(String target, int maxLength) {
        return target.length() > maxLength;
    }

    public static boolean hasDuplicates(List<String> list) {
        Set<String> set = list.stream().collect(Collectors.toSet());
        return set.size() != list.size();
    }

    public static String joinListWithComma(List<String> targetList) {
        return String.join(", ", targetList);
    }

}
