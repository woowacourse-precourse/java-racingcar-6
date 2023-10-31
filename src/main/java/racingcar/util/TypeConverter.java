package racingcar.util;

import java.util.List;
import java.util.stream.Stream;

public class TypeConverter {

    private static final String DELIMiTER = ",";
    private static final String WRONG_INPUT_MSG = "1 이상의 숫자만 입력해주세요.";

    public static List<String> toList(String input) {
        return Stream.of(input.split(DELIMiTER))
                .toList();
    }

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_INPUT_MSG);
        }
    }
}
