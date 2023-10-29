package racingcar;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {
    private final static String SPLIT_POINT = ",";
    public static Map<String, Integer> stringToMap(String input){
        LinkedHashMap<String, Integer> map = Arrays.stream(input.split(","))
                .collect(Collectors.toMap(key -> key, value -> 0, (v1, v2) -> {
                    throw new IllegalArgumentException(InputValidator.DUPLICATED_NAME);
                }, LinkedHashMap::new));
        return map;
    }
}
