package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Verification {

    //입력 이름이 5자 이상인지 확인
    public void verifyArg(List<String> strings) {
        for (String string : strings) {
            if (string.length() > 5) {
                throw new IllegalArgumentException(Exceptions.OVER_5ARG.errMessage());
            }
        }
    }

    //입력 이름중에 중복이 있는지 확인
    public void verifyDuplication(List<String> names) {
        String removed;
        List<String> check = new ArrayList<>(names);
        int size = names.size();

        for (int i = size - 1; i >= 1; i--) {
            removed = check.remove(i);
            if (check.contains(removed)) {
                throw new IllegalArgumentException(Exceptions.DUPLICATION.errMessage());
            }
        }
    }

    //입력한 시도회수가 자연수인지 확인
    public void verifyNumberOfTry(String number) {
        try {
            int parseInt = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exceptions.INPUT_IS_NOT_INTEGER.errMessage());
        }
        if (Integer.parseInt(number) <= 0) {
            throw new IllegalArgumentException(Exceptions.INPUT_IS_NOT_OVER_ZERO.errMessage());
        }
    }
}
