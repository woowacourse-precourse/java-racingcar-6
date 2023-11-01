package racingcar.common;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {
    private final static String SPLIT_POINT = ",";
    private final static String NOT_INTEGER_MESSAGE = "숫자를 입력해주세요.";

    public static Map<String, Integer> stringToMap(String input){
        LinkedHashMap<String, Integer> map = Arrays.stream(input.split(","))
                .collect(Collectors.toMap(key -> key, value -> 0, (v1, v2) -> {
                    throw new IllegalArgumentException(InputValidator.DUPLICATED_NAME);
                }, LinkedHashMap::new));
        return map;
    }

    public static int stringToInteger(String count){
        try{
            return Integer.parseInt(count);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }
}
