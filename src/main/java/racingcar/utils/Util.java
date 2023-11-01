package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static String trim(String carNames) {
        Pattern trimPattern = Pattern.compile(Constants.SPACE_REGEX.getValue());
        Matcher matcher = trimPattern.matcher(carNames);
        return matcher.replaceAll("");
    }

    public static ArrayList<String> toArrayList(String carNames) {
        String[] names = trim(carNames).split(",");
        return new ArrayList<>(Arrays.asList(names));
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public static long countDuplicate(List<String> namelist) {
        return namelist.stream()
                .filter(name -> Collections.frequency(namelist, name) > 1)
                .count();
    }

    public static int getMaxValue(ArrayList<Integer> integers) {
        return integers.stream()
                .max(Integer::compare)
                .orElse(-1);
    }
}
