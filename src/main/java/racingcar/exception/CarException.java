package racingcar.exception;

public class CarException {
    public static void checkName(String name){
        checkLength(name);
        checkBlank(name);
    }

    private static void checkLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException(name + ": 이름의 길이가 5자리를 넘어감");
        }
    }

    private static void checkBlank(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(name + ": 이름에 공백이 포함되었습니다.");
        }
    }

}
