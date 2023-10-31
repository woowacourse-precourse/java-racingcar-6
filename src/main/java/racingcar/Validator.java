package racingcar;

public class Validator {
    public void validateNameArray(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름의 길이는 5자 이하만 가능합니다");
            }
        }
    }
}
