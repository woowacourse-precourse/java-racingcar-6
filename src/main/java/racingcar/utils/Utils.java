package racingcar.utils;

import racingcar.Const;

import java.util.List;

public class Utils {

    public static List<String> split(String str) {
        return List.of(str.split(Const.SEPARATOR));
    }
}
