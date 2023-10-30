package racingcar.domain;

public class CarName {

    public static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateInRange(name);
        validateEmptyName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateInRange(String name) {
        if(name.length()> NAME_MAX_LENGTH){
            throw new IllegalArgumentException("이름의 길이를 5이하로 해주세요");
        }
    }

    private void validateEmptyName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
    }
}
