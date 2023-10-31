package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtils {

    public StringUtils() {
    }

    private final String SEPARATOR = ",";
    private final String SPACE = " ";

    public List<String> separateAndRemoveSpace(String string) {
        List<String> list = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(string, SEPARATOR);
        while (stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken();
            list.add(removeSpace(carName));
        }

        return list;
    }

    public String removeSpace(String carName) {
        return carName.replaceAll(SPACE, "");
    }
}
