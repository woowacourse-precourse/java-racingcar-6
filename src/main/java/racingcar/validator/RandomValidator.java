package racingcar.validator;

import java.util.List;

public class RandomValidator {
    public static void validateMakeRandomNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0 || number > 9) {
                throw new IllegalArgumentException("[ERROR] 랜덤 값이 잘못 생성되었습니다.");
            }
        }
    }
}