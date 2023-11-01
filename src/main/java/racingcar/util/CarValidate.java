package racingcar.util;

public class CarValidate {
    public static String checkCarName(String name) throws IllegalArgumentException{
        checkCarNameMaxLength(name);
        checkCarNameMinLength(name);
        checkSpace(name);
        return name;
    }

    private static void checkCarNameMaxLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[Error] 자동차의 이름은 5글자 이내여야 합니다.");
        }

    }

    private static void checkCarNameMinLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[Error] 자동차의 이름은 1글자 이상이여야 합니다.");
        }
    }

    private static void checkSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("[Error] 자동차의 이름에 공백이 들어가면 안됩니다.");
        }
    }
}
