package racingcar.domain;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateName(name);
        validateEmptyName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if(name.length()>5){
            throw new IllegalArgumentException("이름의 길이를 5이하로 해주세요");
        }
    }

    private void validateEmptyName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
    }
}
