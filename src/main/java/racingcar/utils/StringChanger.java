package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StringChanger {
    public static String[] stringToTrimStringArray(String string){
        return Stream.of(string.split(",",-1)).map(String::trim).toArray(String[]::new);
    }

    public static List<String> stringArrayToStringList(String[] strings){
        return new ArrayList<>(Arrays.asList(strings));
    }
}
