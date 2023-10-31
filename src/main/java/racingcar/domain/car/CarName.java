package racingcar.domain.car;

public class CarName {

    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateNull(name);
        validateInRange(name);
        validateEmptyName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateInRange(String name) {
        if(inRange(name)){
            throw new IllegalArgumentException("이름의 길이를 5이하로 해주세요");
        }
    }

    private static boolean inRange(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    private void validateEmptyName(String name){
        if(isEmpty(name)){
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
    }

    private static boolean isEmpty(String name) {
        return name.isEmpty();
    }

    private static void validateNull(String name){
        if(isNull(name)){
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
    }

    private static boolean isNull(String name) {
        return name == null;
    }
}
