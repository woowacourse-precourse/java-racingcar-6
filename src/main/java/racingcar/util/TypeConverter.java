package racingcar.util;

import java.util.List;

public class TypeConverter {

    public List<String> convertToList(String input) {
        checkSplitUnit(input);
        String[] split = input.split(",");
        return List.of(split);
    }

    private void checkSplitUnit(String input) {
        if (input.matches("")) {
            throw new IllegalArgumentException("쉼표(,)로만 구분 가능합니다.");
        }
    }
}
