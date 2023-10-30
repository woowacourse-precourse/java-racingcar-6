package racingcar.generator;

import static racingcar.converter.NumToDash.createDashString;

public class DashStringGenerator {
    public static String DashStringGenerator(int index, int[] winArray) {
        if (index >= 0 && index < winArray.length) {
            int count = winArray[index];
            return createDashString(count);
        }
        return ""; // 유효하지 않은 인덱스에 대한 처리
    }
}
