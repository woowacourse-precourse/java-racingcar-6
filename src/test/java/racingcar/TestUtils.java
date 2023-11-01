package racingcar;

import static racingcar.global.enums.Constant.MAX_NAME_LENGTH;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtils {

    public static String generateNameExceedingMaxLength() {
        String name = IntStream.range(0, MAX_NAME_LENGTH.getConstant() + 1)
                .mapToObj(i -> "a")
                .collect(Collectors.joining());
        return name;
    }

}

