package racingcar;

import java.util.List;

public class DataTypeChanger {
    public static List<String> stringToList(String names) {
        names = names.replace(" ", "");
        return List.of(names.split(","));
    }
}
