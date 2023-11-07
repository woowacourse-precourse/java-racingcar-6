package racingcar.model;

import racingcar.service.ShiftGear;
import racingcar.validation.CarValidator;
import racingcar.validation.Validator;

public class Car implements Comparable<Car> {
    private static final String MARK = "-";
    private final String name;
    private Integer currentPosition;

    public Car(String name){
        validateName(name);
        this.name = name;
        this.currentPosition = 0;
    }

    public void move() {
        if (ShiftGear.moveForward()){
            currentPosition++;
        }
    }

    private void validateName(String value){
        Validator carValidator = new CarValidator();
        if(carValidator.support(Car.class)) {
            carValidator.validate(value);
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        return this.name + " : " + MARK.repeat(this.currentPosition);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if(!(obj instanceof Car car)){
            return false;
        }
        return this.currentPosition.equals(car.currentPosition);
    }

    @Override
    public int compareTo(Car car) {
        return this.currentPosition - car.currentPosition;
    }

//    private void validateName(String name){
//        validateLength(name);
//    }
//
//    private void validateLength(String value){
//        if(MIN_LENGTH.getPlayValue() > value.length() || value.length() > MAX_LENGTH.getPlayValue()){
//            throw new IllegalArgumentException();
//        }
//    }
}
