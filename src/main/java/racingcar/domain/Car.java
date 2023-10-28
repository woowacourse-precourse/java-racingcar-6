package racingcar.domain;

public class Car {
    String carName;

    public Car(String carName) {
        validationLength(carName);
        this.carName = carName;
    }

    private void validationLength(String carName) {
        if(carName.length() > 5){
            throw new IllegalArgumentException("Limit length 5");
        }
    }
}
