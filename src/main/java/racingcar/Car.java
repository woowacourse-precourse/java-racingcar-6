package racingcar;

import java.util.Objects;

public class Car {
    private final String car;

    public Car(String car) {
        validate_length(car);
        validate_leading_space(car);
        this.car = car;
    }

    private void validate_length(String car) {
        if (car.length() > Constant.MAX_CAR_NAME_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_NAME_LENGTH);
        }
    }

    private void validate_leading_space(String car){
        if(car.charAt(0) == ' '){
            throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_NAME_LEADING_SPACE);
        }
    }

    public String getName(){
        return car;
    }

    public String toString() {
        return String.valueOf(this.car);
    }

}
