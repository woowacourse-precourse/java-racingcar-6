package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToListConverter implements Converter<String, List<String>> {
    private static final String DELIMITER = ",";

    @Override
    public List<String> convert(String source) {
        return Arrays.stream(source.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
