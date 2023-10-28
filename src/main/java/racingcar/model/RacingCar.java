package racingcar.model;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_CONDITION = 4;
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

    public CarGear apply(int condition){
        if(condition >= FORWARD_CONDITION){
            return CarGear.FORWARD;
        }
        return CarGear.STOP;
    }
}
