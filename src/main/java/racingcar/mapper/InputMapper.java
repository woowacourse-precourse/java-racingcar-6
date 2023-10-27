package racingcar.mapper;

import java.util.List;
import java.util.Objects;

public class InputMapper {

    public static List<String> mapToNameList(String input) {
        checkInputNonNull(input);

        return List.of(input.split(Delimiter.NAME.getShape()));
    }

    private static void checkInputNonNull(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }
}
