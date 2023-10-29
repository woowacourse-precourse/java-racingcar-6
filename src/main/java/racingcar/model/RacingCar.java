package racingcar.model;

import java.util.Objects;

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

    public CarStatus apply(int condition){
        if(condition >= FORWARD_CONDITION){
            return CarStatus.FORWARD;
        }
        return CarStatus.STOP;
    }

    @Override
    public String toString() {
        return name + " : ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
