package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CarNameSeperator {

    private static final String DILIMITER =",";

    public List<String> seperateCarNames(final String input) {
        StringTokenizer stringtokenizer = new StringTokenizer(input, DILIMITER);
        List<String> result = new ArrayList<>();

        while (stringtokenizer.hasMoreTokens()) {
            result.add(stringtokenizer.nextToken());
        }

        return result;
    }
}
