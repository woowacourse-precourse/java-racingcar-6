package validate;

import exceptional.ExceptionalCarNameRangeout;
import java.util.List;

public class ValidateNameInRange {

    private ValidateNameInRange() {
    }

    public static List<String> nameInRange(List<String> CarNames) {

        for (int i = 0; i < CarNames.size(); i++) {
            throwCarNameExceptional(i, CarNames);
        }
        return CarNames;
    }

    private static void throwCarNameExceptional(int i, List<String> CarNames) {
        if (5 < CarNames.get(i).length()) {
            ExceptionalCarNameRangeout.exception();
        }
    }

}
