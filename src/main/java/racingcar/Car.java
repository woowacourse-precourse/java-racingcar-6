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
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
        }
    }

    private void validate_leading_space(String car){
        if(car.charAt(0) == ' '){
            throw new IllegalArgumentException("이름 앞에 공백이 있습니다.");
        }
    }

    public String getName(){
        return car;
    }

    public String toString() {
        return String.valueOf(this.car);
    }

}
