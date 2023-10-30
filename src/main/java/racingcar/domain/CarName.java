package racingcar.domain;

public class CarName {
    String name;

    public CarName(String name) {
        validateName(name);
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
}
