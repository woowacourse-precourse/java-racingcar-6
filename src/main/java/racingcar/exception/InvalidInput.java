package racingcar.exception;

import java.util.ArrayList;
import java.util.List;

public class InvalidInput {
    public static void longNameException(String name) {
        if (name.length() >= 6) {
            throw new IllegalArgumentException("이름은 최대 5글자 입니다.");
        }
    }

    public static void DuplicateNameException(String[] namesArray) {
        List<String> nameList = new ArrayList<>();

        for (String name : namesArray) {
            if (nameList.contains(name)) {
                throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
            }
            nameList.add(name);
        }
    }

    public static void NotIntegerValueException(String number) {
        try{
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("횟수는 숫자 여야 합니다.");
        }
    }

    public static void OutOfRangeException(String number) {
        int num = Integer.parseInt(number);

        if (num <= 0) {
            throw new IllegalArgumentException("횟수는 1 이상 이어야 합니다.");
        }
    }
}
