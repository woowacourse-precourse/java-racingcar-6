package racingcar.view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static boolean hasValidContent(List<String> names) {
        return !names.isEmpty() && names.stream().noneMatch(name -> name.trim().isEmpty());
    }

    private static boolean hasValidLength(List<String> names, int max) {
        return names.stream().allMatch(name -> name.length() <= max);
    }

    private static boolean hasUniqueName(List<String> names) {
        Set<String> namesSet = new HashSet<String>(names);

        return namesSet.size() == names.size();
    }

    public static boolean names(List<String> names) {
        return hasValidContent(names) && hasValidLength(names, 5) && hasUniqueName(names);
    }
}
