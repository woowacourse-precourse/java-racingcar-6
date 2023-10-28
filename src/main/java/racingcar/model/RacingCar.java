package racingcar.model;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name){
        if(name.isEmpty() || name.length() > MAX_NAME_LENGTH ){
            throw new IllegalArgumentException("이름은 5자 이하의 구분 가능한 문자로 이루어져야 합니다.");
        }
    }
}
