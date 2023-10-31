package racingcar.model;

import racingcar.constant.CarStatus;
import racingcar.constant.ExceptionResponse;

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
        name = name.trim();
        if(name.isEmpty() || name.length() > MAX_NAME_LENGTH ){
            throw new IllegalArgumentException(ExceptionResponse.RACING_CAR_NAME.getMessage());
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
        return name;
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
