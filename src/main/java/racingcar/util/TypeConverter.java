package racingcar.util;

import java.util.List;
import java.util.stream.Stream;

public class TypeConverter {

    private static final String DELIMiTER = ",";

    public static List<String> toList(String input) {
        return Stream.of(input.split(DELIMiTER))
                .toList();
    }
}
