package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtil {

    public ArrayList<String> arrayList(String input){
        return new ArrayList<>(Arrays.asList(input.split(",")));

    }
}
