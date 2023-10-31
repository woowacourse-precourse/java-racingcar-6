package racingcar;

import java.util.Arrays;

public class ExceptionInput {
    public static boolean checkNameLength(String[] names) {

        Arrays.sort(names);

        int minNameLen = names[0].length();
        int maxNameLen = names[names.length-1].length();

        return minNameLen >= Constants.MIN_NAME_LEN && maxNameLen <= Constants.MAX_NAME_LEN;
    }
}
