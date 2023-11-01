package util;

import java.util.Arrays;
import java.util.List;

public class ReformatHandler {

    public static int stringToNum(String number) {
        return Integer.parseInt(number);
    }

    public static List<String> nameListDivider(String names) {
        List<String> nameList = Arrays.asList(names.split(","));
        return nameList;
    }

}
