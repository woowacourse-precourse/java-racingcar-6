package racingcar.model.car;

import racingcar.service.ShiftGear;
import racingcar.validation.CarValidator;
import racingcar.validation.Validator;

import java.util.Comparator;

// TODO : 자동차 경주에 말이 들어 온다면?
public class Car {
    private static final String MARK = "-";
    // TODO : 어떻게 선언 할까
    private final Comparator<Car> comparator = new OrderByPosition();

    protected String name;
    protected Integer currentPosition;

    public Car(String name){
        validate(name);
//        this.name = name;
//        this.currentPosition = 0;
    }

    public void move() {
        if (ShiftGear.moveForward()){
            currentPosition++;
        }
    }

    private void validate(String value){
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

    public int compareTo(Car car) {
        return comparator.compare(this, car);
//        return this.currentPosition - car.currentPosition;
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
